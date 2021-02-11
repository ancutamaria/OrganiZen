package com.amg.organizen.model.repository

sealed class MyResponse<out T> {

    data class OK<out V>(val data: V?): MyResponse<V>()
    data class Error(val message: String): MyResponse<Nothing>()

}