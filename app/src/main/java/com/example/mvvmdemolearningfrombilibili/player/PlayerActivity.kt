package com.example.mvvmdemolearningfrombilibili.player

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmdemolearningfrombilibili.R
import com.example.mvvmdemolearningfrombilibili.base.BaseActivity
import com.example.mvvmdemolearningfrombilibili.domain.musicList.MusicPresenterOld

class PlayerActivity : BaseActivity() {

    private val musicPresenter by lazy {
        MusicPresenterOld(this)
    }

    private val playerPresenter by lazy {
//        PlayerPresenter()
    }
//
//    init {
//        lifeProvider.addLifeListener(playerPresenter)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        initListener()
        initDataListener()
    }

    private val livePlayerObserver by lazy {
        LivePlayerStateObserver()
    }

    class LivePlayerStateObserver : Observer<PlayerPresenter.PlayState> {
        override fun onChanged(t: PlayerPresenter.PlayState?) {
            println("播放器界面...live data --> 当前状态  ￥t")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        LivePlayerState.instance.removeObserver(livePlayerObserver)
    }

    private fun initDataListener() {
        LivePlayerState.instance.observeForever(livePlayerObserver)
    }

    private fun initListener() {

    }
}