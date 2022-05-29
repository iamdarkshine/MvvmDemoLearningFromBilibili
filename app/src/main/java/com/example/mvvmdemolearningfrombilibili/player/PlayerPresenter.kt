package com.example.mvvmdemolearningfrombilibili.player

import com.example.mvvmdemolearningfrombilibili.DataListenContainer
import com.example.mvvmdemolearningfrombilibili.domain.musicList.Music
import com.example.mvvmdemolearningfrombilibili.lifecycle.*

class PlayerPresenter(owner: ILifecycleOwner) : AbsLifecycle(){

    private val playerModel by lazy {
        PlayerModel()
    }

    var currentMusic = DataListenContainer<Music>()

    var currentPlayState = DataListenContainer<PlayState>()

    var livePlayerState = LivePlayerState.instance

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
        if (currentMusic.value == null) {
            // 获取一首歌曲

        }

        if (currentPlayState.value != PlayState.PLAYING) {
            livePlayerState.postValue(PlayState.PLAYING)
        } else {
            livePlayerState.postValue(PlayState.PAUSE)
        }
    }

    override fun onViewLifeStateChange(state: LifeState) {

    }
}