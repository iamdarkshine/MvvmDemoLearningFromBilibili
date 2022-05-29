package com.example.mvvmdemolearningfrombilibili.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmdemolearningfrombilibili.domain.musicList.Music
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycle
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycleOwner
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifeState
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifecycleProvider

open class BaseActivity : AppCompatActivity(), ILifecycleOwner {

    val lifeProvider by lazy {
        LifecycleProvider()
    }



    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        lifeProvider.makeLifeState(LifeState.CREATE)
    }

    override fun onStart() {
        super.onStart()
        lifeProvider.makeLifeState(LifeState.START)
    }

    override fun onResume() {
        super.onResume()
        lifeProvider.makeLifeState(LifeState.RESUME)
    }

    override fun onPause() {
        super.onPause()
        lifeProvider.makeLifeState(LifeState.PAUSE)
    }

    override fun onStop() {
        super.onStop()
        lifeProvider.makeLifeState(LifeState.STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeProvider.makeLifeState(LifeState.DESTROY)
    }

    override fun getLifecycleProvider(): LifecycleProvider {
        return lifeProvider
    }
}