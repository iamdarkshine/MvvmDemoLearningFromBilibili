package com.example.mvvmdemolearningfrombilibili

import android.os.Looper
import android.util.Log
import com.example.mvvmdemolearningfrombilibili.lifecycle.AbsLifecycle
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycleOwner
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifeState
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifecycleProvider

class DataListenContainer<T> {
    private val blocks = arrayListOf<(T?) -> Unit>()
    private val viewLifecycleProviders = hashMapOf<(T?) -> Unit, LifecycleProvider>()

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
        val viewLifecycleProvider = viewLifecycleProviders[it]
        if (viewLifecycleProvider != null && viewLifecycleProvider.isAtLeast(LifeState.START)) {
            println("更新UI...")
            it.invoke(value)
        }
    }

    /**
     * 有可能有多个View进行监听
     * 所有owner-block
     * 得管理起来
     */
    fun addListener(owner:ILifecycleOwner, valueObserver: (T?) -> Unit) {
        val lifecycleProvider = owner.getLifecycleProvider()
        viewLifecycleProviders[valueObserver] = lifecycleProvider
        // TODO 当View Destroy时，要从集合中删除
        val observerWrapper = ValueObserverWrapper(valueObserver)
        lifecycleProvider.addLifeListener(observerWrapper)
        if(!blocks.contains (valueObserver)) {
            blocks.add(valueObserver)
        }
    }

    inner class ValueObserverWrapper(private val valueObserver: (T?) -> Unit) : AbsLifecycle() {
        override fun onViewLifeStateChange(state: LifeState) {
            // 监听到当前View生命周期为Destroy时，把LifecycleProvider从集合中删除
            if (state == LifeState.DESTROY) {
                viewLifecycleProviders.remove(valueObserver)
            }
        }

    }


}