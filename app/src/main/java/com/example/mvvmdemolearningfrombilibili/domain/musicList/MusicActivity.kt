package com.example.mvvmdemolearningfrombilibili.domain.musicList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemolearningfrombilibili.R

class MusicActivity : AppCompatActivity() {

    private val musicPresenter by lazy {
        MusicPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initViewListener()
    }

    private fun initViewListener() {
        getMusicBtn.setOnC
    }
}