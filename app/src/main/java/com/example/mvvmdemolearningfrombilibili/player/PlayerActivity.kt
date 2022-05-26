package com.example.mvvmdemolearningfrombilibili.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemolearningfrombilibili.R
import com.example.mvvmdemolearningfrombilibili.base.BaseActivity
import com.example.mvvmdemolearningfrombilibili.domain.musicList.MusicPresenter

class PlayerActivity : BaseActivity() {

    private val musicPresenter by lazy {
        MusicPresenter(this)
    }

//    private val playerPresenter by lazy {
//        PlayerPresenter()
//    }
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

    private fun initDataListener() {

    }

    private fun initListener() {

    }
}