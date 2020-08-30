package com.example.challengeambar.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private fun initRetrofit(): Retrofit {
        val baseUrl = "https://api.github.com"

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: GitApi = initRetrofit()
        .create(GitApi::class.java)
}