package com.example.mvvmdemolearningfrombilibili.domain.musicList

import com.example.mvvmdemolearningfrombilibili.base.BaseFragment

class MusicDetailFragment: BaseFragment() {

    private val musicPresenter by lazy {
        MusicPresenterOld(owner = this)
    }





}