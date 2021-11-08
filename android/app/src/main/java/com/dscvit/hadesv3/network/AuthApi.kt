package com.dscvit.hadesv3.network

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("auth/email/login/")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Any

    @FormUrlEncoded
    @POST("auth/email/register")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("first_name") firstName: String,
        @Field("last_name") lastName: String,
        @Field("phone_no") phoneNo: Long
    ): Any
}