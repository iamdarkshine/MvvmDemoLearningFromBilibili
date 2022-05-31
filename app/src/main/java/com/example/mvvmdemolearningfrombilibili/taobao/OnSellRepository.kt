package com.example.mvvmdemolearningfrombilibili.taobao

import com.example.mvvmdemolearningfrombilibili.api.RetrofitClient

class OnSellRepository {

    suspend fun getOnSellList(page: Int) = RetrofitClient.apiService.getOnSellList(page).apiData()

}