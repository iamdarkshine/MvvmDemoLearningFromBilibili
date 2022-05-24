package com.example.mvvmdemolearningfrombilibili.domain.musicList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemolearningfrombilibili.R
import com.example.mvvmdemolearningfrombilibili.base.BaseActivity
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : BaseActivity() {

    private val musicPresenter by lazy {
        MusicPresenter()
    }

    init {
        lifeProvider.addLifeListener(musicPresenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initDataListener()
        initViewListener()
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