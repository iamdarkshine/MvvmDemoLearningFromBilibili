package com.example.mvvmdemolearningfrombilibili.lifecycle

interface ILifecycleOwner {
    fun getLifecycleProvider() : LifecycleProvider
}