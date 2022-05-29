package com.example.mvvmdemolearningfrombilibili.taobao

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecommendViewModel: ViewModel() {

    val contentList = MutableLiveData<MutableList<String>>()
}