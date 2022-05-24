package com.example.mvvmdemolearningfrombilibili.player

import com.example.mvvmdemolearningfrombilibili.DataListenContainer
import com.example.mvvmdemolearningfrombilibili.domain.musicList.Music
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycle

class PlayerPresenter{

    var currentMusic = DataListenContainer<Music>()

    var currentPlayState = DataListenContainer<PlayState>()

    companion object {
        val instance by lazy {
            PlayerPresenter()
        }
    }

    enum class PlayState {
        NONE, PLAYING, PAUSE, LOADING
    }

    fun doPlayOrPause() {
        
    }
}