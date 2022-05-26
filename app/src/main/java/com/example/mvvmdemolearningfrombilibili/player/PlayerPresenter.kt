package com.example.mvvmdemolearningfrombilibili.player

import com.example.mvvmdemolearningfrombilibili.DataListenContainer
import com.example.mvvmdemolearningfrombilibili.domain.musicList.Music
import com.example.mvvmdemolearningfrombilibili.lifecycle.*

class PlayerPresenter(owner: ILifecycleOwner) : AbsLifecycle(){


    var currentMusic = DataListenContainer<Music>()

    var currentPlayState = DataListenContainer<PlayState>()

    companion object : ILifecycleOwner {
        val instance by lazy {
            PlayerPresenter(owner = this)
        }

        override fun getLifecycleProvider(): LifecycleProvider {
            return LifecycleProvider()
        }


    }

    enum class PlayState {
        NONE, PLAYING, PAUSE, LOADING
    }

    fun doPlayOrPause() {

    }

    override fun onViewLifeStateChange(state: LifeState) {

    }
}