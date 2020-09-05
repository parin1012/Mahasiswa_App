package com.udacoding.mahasiswa_app_eriennadaazandra.Config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("http://172.16.20.11/mentoring_kotlin_week4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service () : ApiService = getRetrofit().create(ApiService::class.java)

}