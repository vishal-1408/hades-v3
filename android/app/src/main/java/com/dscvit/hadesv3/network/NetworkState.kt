package com.dscvit.hadesv3.network

import okhttp3.ResponseBody

sealed class NetworkState<out T> {
    // we have generic sealed class for holding response of any type when network request is a success
    data class Success<out T>(val response: T) : NetworkState<T>()
    data class Failure(
        val networkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : NetworkState<Nothing>()

    object Loading : NetworkState<Nothing>()
}