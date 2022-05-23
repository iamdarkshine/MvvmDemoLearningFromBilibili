package com.example.mvvmdemolearningfrombilibili.domain.musicList

import com.example.mvvmdemolearningfrombilibili.DataListenContainer
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycle

class MusicPresenter : ILifecycle {
    enum class MusicLoadState {
        LOADING, EMPTY, SUCCESS, ERROR
    }

    private val musicModel by lazy {
        MusicModel()
    }
    val musicList = DataListenContainer<List<Music>>()
    val loadState = DataListenContainer<MusicLoadState>()
    private val page = 1
    private val size = 30

    fun getMusic() {
        loadState.value = MusicLoadState.LOADING
        // 从model层中获取音乐，列表
        musicModel.loadMusicByPage(page, size, object : MusicModel.OnMusicLoadResult {
            override fun onSuccess(result: List<Music>) {
                musicList.value = result
                loadState.value = if (result.isEmpty()) {
                    MusicLoadState.EMPTY
                } else {
                    MusicLoadState.SUCCESS
                }
            }

            override fun onError(msg: String, code: Int) {
                loadState.value = MusicLoadState.ERROR
            }
        })
    }

    override fun onCreate() {

    }

    override fun onStart() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        TODO("Not yet implemented")
    }

    override fun onStop() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}