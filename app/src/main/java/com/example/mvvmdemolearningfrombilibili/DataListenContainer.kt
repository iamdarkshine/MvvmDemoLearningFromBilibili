package com.example.mvvmdemolearningfrombilibili

import android.os.Looper
import androidx.arch.core.executor.ArchTaskExecutor

class DataListenContainer<T> {
    private val blocks = arrayListOf<(T?) -> Unit>()

    var value: T? = null
        // 当数据变化时，通知更新
        set(value: T?) {
            // 判断当前现冲是不是主线程
            // 若是，直接执行，否则切换到主线程再执行
            if (Looper.getMainLooper().thread == Thread.currentThread()) {
                blocks.forEach {
                    it.invoke(value)
                }
            } else {
                App.handler.post {
                    blocks.forEach {
                        it.invoke(value)
                    }
                }
            }
        }
}