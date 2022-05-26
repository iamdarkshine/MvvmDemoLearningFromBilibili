package com.example.mvvmdemolearningfrombilibili.domain.musicList

import com.example.mvvmdemolearningfrombilibili.base.BaseFragment

class MusicListFragment : BaseFragment() {

    private val musicPresenter by lazy {
        MusicPresenter(owner = this)
    }

}