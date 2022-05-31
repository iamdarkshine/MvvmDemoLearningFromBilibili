package com.example.mvvmdemolearningfrombilibili.api

class ApiException(val code: Int, override val message: String?): RuntimeException() {
}