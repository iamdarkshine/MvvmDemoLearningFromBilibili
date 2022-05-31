package com.example.mvvmdemolearningfrombilibili.domain

import com.example.mvvmdemolearningfrombilibili.api.ApiException

data class ResultData<T>(val success: Boolean,
val code: Int,
val message: String,
val data: T) {

    companion object {
        const val CODE_SUCCESS = 10000
    }

    fun apiData(): T {
        // 若成功，返回数据，否则，抛出异常
        if (code == CODE_SUCCESS) {
            return data
        } else {
            throw ApiException(code, message)
        }
    }
}