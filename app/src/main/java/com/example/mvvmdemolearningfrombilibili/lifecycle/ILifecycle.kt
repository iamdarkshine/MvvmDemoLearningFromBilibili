package com.example.mvvmdemolearningfrombilibili.lifecycle

interface ILifecycle {
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}