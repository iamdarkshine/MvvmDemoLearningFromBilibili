package com.example.mvvmdemolearningfrombilibili

import com.example.mvvmdemolearningfrombilibili.domain.musicList.Music

class PlayerPresenter {
    fun getMusicById(id: String) : Music {
        return Music(
            name= "歌曲名: $id",
        cover= "https://cdn.sunofbeaches.com/images/vip_ad.png",
        url= "https://www.sunofbeach.net"
        )
    }
}