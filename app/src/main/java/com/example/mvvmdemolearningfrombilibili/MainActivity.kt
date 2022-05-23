package com.example.mvvmdemolearningfrombilibili

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }






    class MusicModel {
        fun loadMusicByPage(page: Int, size: Int, callback: OnMusicLoadResult) {
            val result: ArrayList<Music> = arrayListOf<Music>()
            Thread {
                for (i: Int in (0 until size)) {
                    result.add(
                            Music(
                                    name: "音乐的名称 $i",
                                    cover: "音乐的封面 $i",
                                    url: "url ==> $i"
                            )
                    )
                }
                // 数据请求完成
                // 通知数据更新
                callback.onSuccess(result)
            }.start()
        }
    }


}