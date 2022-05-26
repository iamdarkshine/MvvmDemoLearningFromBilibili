package com.example.mvvmdemolearningfrombilibili.domain.musicList

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvvmdemolearningfrombilibili.base.BaseFragment
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifeState
import com.example.mvvmdemolearningfrombilibili.lifecycle.LifecycleProvider

class MusicDetailFragment: BaseFragment() {

    private val musicPresenter by lazy {
        MusicPresenter(owner = this)
    }





}