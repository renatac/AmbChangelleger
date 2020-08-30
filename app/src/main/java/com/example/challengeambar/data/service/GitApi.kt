package com.example.challengeambar.data.service

import com.example.challengeambar.data.Response.GitResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitApi {
    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/repositories")
    fun getGitList(@Query("since") since: Int = 100):
            Call<List<GitResponse>>
}