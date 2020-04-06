package com.lintang.jetpackprolintang.base.utils

import com.google.gson.Gson

open class BaseHelper {

    fun <T> baseToJson(model: T): String? {
        return Gson().toJson(model)
    }

    inline fun <reified T> baseFromJson(word: String?): T {
        return Gson().fromJson<T>(word, T::class.java)
    }

}