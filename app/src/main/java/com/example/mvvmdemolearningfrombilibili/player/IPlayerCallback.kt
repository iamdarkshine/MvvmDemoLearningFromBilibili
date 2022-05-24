package com.example.mvvmdemolearningfrombilibili.player

interface IPlayerCallback {
    fun onTitleChange(title: String)

    fun onProgressChange(current: Int)

    fun onPlaying()

    fun onPause()

    fun onCoverChange(cover: String)
}