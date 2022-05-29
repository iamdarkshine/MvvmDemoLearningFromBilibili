package com.example.mvvmdemolearningfrombilibili

import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifeState

class DataListenContainer<T> {
    private val blocks = arrayListOf<(T?) -> Unit>()
    private val viewLifecycleProviders = hashMapOf<(T?) -> Unit, Lifecycle>()

    var value: T? = null
        // 当数据变化时，通知更新
        set(value: T?) {
            // 判断当前现冲是不是主线程
            // 若是，直接执行，否则切换到主线程再执行
            if (Looper.getMainLooper().thread == Thread.currentThread()) {
                // 判断对应View的生命周期是什么
                blocks.forEach {
                    dispatchValue(it, value)
                }
            } else {
                App.handler.post {
                    blocks.forEach {
                        dispatchValue(it, value)
                    }
                }
            }
        }

    private fun dispatchValue(it: (T?) -> Unit, value: T?) {
        val lifecycle = viewLifecycleProviders[it]
        if (lifecycle != null && lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            println("更新UI...")
            it.invoke(value)
        } else {
            println("UI不可见，不进行更新...")
        }
    }

    /**
     * 有可能有多个View进行监听
     * 所有owner-block
     * 得管理起来
     */
    fun addListener(owner: LifecycleOwner, valueObserver: (T?) -> Unit) {
        val lifecycle = owner.lifecycle
        viewLifecycleProviders[valueObserver] = lifecycle
        // TODO 当View Destroy时，要从集合中删除
        val observerWrapper = ValueObserverWrapper(valueObserver)
        lifecycle.addObserver(observerWrapper)
        if(!blocks.contains (valueObserver)) {
            blocks.add(valueObserver)
        }
    }

    inner class ValueObserverWrapper(private val valueObserver: (T?) -> Unit) : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun removeObserver() {
            println("removeObserver...")
            viewLifecycleProviders.remove(valueObserver)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onStop(owner: LifecycleOwner) {
            println("owner === > $owner")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
        fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
            println("owner === > $owner")
            println("event === > $event")
        }

    }


}