package com.example.mvvmdemolearningfrombilibili.domain.musicList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemolearningfrombilibili.R
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity() {

    private val musicPresenter by lazy {
        MusicPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initDataListener()
        initViewListener()
        musicPresenter.onCreate()
    }

    override fun onStart() {
        super.onStart()
        musicPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        musicPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        musicPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        musicPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPresenter.onDestroy()
    }

    private fun initDataListener() {
        musicPresenter.musicList.addListener {

        }
        musicPresenter.loadState.addListener {

        }
    }

    private fun initViewListener() {
        getMusicBtn.setOnClickListener {
            musicPresenter.getMusic()

        }
    }
}