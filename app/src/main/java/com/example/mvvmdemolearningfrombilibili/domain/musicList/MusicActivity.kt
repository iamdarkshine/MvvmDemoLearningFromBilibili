package com.example.mvvmdemolearningfrombilibili.domain.musicList

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmdemolearningfrombilibili.R
import com.example.mvvmdemolearningfrombilibili.base.BaseActivity
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : BaseActivity() {

    private val musicPresenter by lazy {
        MusicPresenter(owner = this)
    }

//    init {
//        lifeProvider.addLifeListener(musicPresenter)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        initDataListener()
        initViewListener()
    }

    lateinit var mForeverObserver: ForeverObserver

    inner class ForeverObserver: Observer<List<Music>> {
        override fun onChanged(result: List<Music>?) {
            println("forever observer data change ==> ${result?.size}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPresenter.liveMusicList.removeObserver(mForeverObserver)
    }


    private fun initDataListener() {
//        mForeverObserver = ForeverObserver()
//        musicPresenter.liveMusicList.observeForever(mForeverObserver)
        musicPresenter.liveMusicList.observe(this, Observer {
            println("live data 中的音乐列表数据更新了.....${it.size}")
        })

        musicPresenter.musicList.addListener(this) {
            println("加载状态 --- > ${it?.size}条数据")
        }
        musicPresenter.loadState.addListener(this) {
            println("加载状态 --- > $it")
        }
    }

    private fun initViewListener() {
        getMusicBtn.setOnClickListener {
            musicPresenter.getMusic()

        }
    }
}