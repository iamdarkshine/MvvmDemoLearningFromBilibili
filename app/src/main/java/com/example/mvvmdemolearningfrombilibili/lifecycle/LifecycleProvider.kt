package com.example.mvvmdemolearningfrombilibili.lifecycle

/**
 * 管理注册进来的接口
 * 保存当前View的生命周期状态
 */
class LifecycleProvider {

    private var currentLifeState: LifeState = LifeState.DESTROY
    private val lifecycleListener = arrayListOf<AbsLifecycle>()

    fun addLifeListener(listener: AbsLifecycle) {
        if (!lifecycleListener.contains(listener)) {
            lifecycleListener.add(listener)
        }
    }

    fun removeLifeListener(listener: AbsLifecycle) {
        lifecycleListener.remove(listener)
    }

    fun makeLifeState(state: LifeState) {
        currentLifeState = state
        lifecycleListener.forEach {
            it.onViewLifeStateChange(state)
        }
        when (state) {
            LifeState.CREATE -> {
                dispatchCreateState()
            }
            LifeState.DESTROY -> {
                dispatchDestroyState()
            }
            LifeState.PAUSE -> {
                dispatchPauseState()
            }
            LifeState.RESUME -> {
                dispatchResumeState()
            }
            LifeState.START -> {
                dispatchStartState()
            }
            LifeState.STOP -> {
                dispatchStopState()
            }
        }
    }

    private fun dispatchStopState() {
        lifecycleListener.forEach {
            it.onStop()
        }
    }

    private fun dispatchStartState() {
        lifecycleListener.forEach {
            it.onStart()
        }
    }

    private fun dispatchResumeState() {
        lifecycleListener.forEach {
            it.onResume()
        }
    }

    private fun dispatchPauseState() {
        lifecycleListener.forEach {
            it.onPause()
        }
    }

    private fun dispatchDestroyState() {
        lifecycleListener.forEach {
            it.onDestroy()
        }
        lifecycleListener.clear()
    }

    private fun dispatchCreateState() {
        lifecycleListener.forEach {
            it.onCreate()
        }
    }

    fun isAtLeast(state: LifeState): Boolean {
        println("current state $currentLifeState ===== $state")
        val isAtLeastState = currentLifeState > state
        println("isAtLeastState == > $isAtLeastState")
        return isAtLeastState
    }
}