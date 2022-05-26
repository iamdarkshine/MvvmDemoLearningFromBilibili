package com.example.mvvmdemolearningfrombilibili.domain.musicList

import com.example.mvvmdemolearningfrombilibili.DataListenContainer
import com.example.mvvmdemolearningfrombilibili.lifecycle.AbsLifecycle
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycle
import com.example.mvvmdemolearningfrombilibili.lifecycle.ILifecycleOwner
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifeState

class MusicPresenter(owner: ILifecycleOwner) : AbsLifecycle() {

    private val viewLifeImpl by lazy {
        ViewLifeImpl()
    }

    init {
        owner.getLifecycleProvider().addLifeListener(viewLifeImpl)
    }
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

    inner class ViewLifeImpl : AbsLifecycle() {

        override fun onViewLifeStateChange(state: LifeState) {

        }

    }

    override fun onViewLifeStateChange(state: LifeState) {
        viewLifeImpl.onViewLifeStateChange(state)
    }
}