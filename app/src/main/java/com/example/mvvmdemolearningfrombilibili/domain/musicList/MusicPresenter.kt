package com.example.mvvmdemolearningfrombilibili.domain.musicList

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemolearningfrombilibili.DataListenContainer
import com.example.mvvmdemolearningfrombilibili.lifecycle.AbsLifecycle
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifeState

class MusicPresenter(owner: LifecycleOwner) {
    private val viewLifeImpl by lazy {
        ViewLifeImpl()
    }

    init {
        owner.lifecycle.addObserver(viewLifeImpl)
    }
    enum class MusicLoadState {
        LOADING, EMPTY, SUCCESS, ERROR
    }

    private val musicModel by lazy {
        MusicModel()
    }

    val liveMusicList = MutableLiveData<List<Music>>()

    val musicList = DataListenContainer<List<Music>>()
    val loadState = DataListenContainer<MusicLoadState>()
    private val page = 1
    private val size = 30

    fun getMusic() {
        loadState.value = MusicLoadState.LOADING
        // 从model层中获取音乐，列表
        musicModel.loadMusicByPage(page, size, object : MusicModel.OnMusicLoadResult {
            override fun onSuccess(result: List<Music>) {
                liveMusicList.postValue(result)
//                musicList.value = result
//                loadState.value = if (result.isEmpty()) {
//                    MusicLoadState.EMPTY
//                } else {
//                    MusicLoadState.SUCCESS
//                }
            }

            override fun onError(msg: String, code: Int) {
                loadState.value = MusicLoadState.ERROR
            }
        })
    }

    inner class ViewLifeImpl : LifecycleEventObserver {
        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_START -> {
                    // 监听GPS信号变化
                    println("监听GPS信号变化")
                }
                Lifecycle.Event.ON_PAUSE -> {
                    // 停止GPS信号变化监听
                    println("停止GPS信号变化监听")
                }
                else -> {

                }
            }
        }


    }


}