package com.example.challengeambar.data.Response

import com.google.gson.annotations.SerializedName

data class GitResponse(

    @SerializedName("name")
    val repositoryName: String,

    @SerializedName("owner")
    val owner: OwnerResponse,

    @SerializedName("html_url")
    val url: String
)
