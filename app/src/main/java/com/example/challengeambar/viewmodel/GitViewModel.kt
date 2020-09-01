package com.example.challengeambar.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeambar.data.Response.GitResponse
import com.example.challengeambar.data.model.Git
import com.example.challengeambar.data.service.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitViewModel : ViewModel() {

    val gitMutableLiveData = MutableLiveData<List<Git>>()

    companion object {
        const val VIEW_FLIPPER_GIT_LIST = 1
        const val VIEW_FLIPPER_ERROR = 2
    }

    fun getGitResponse() {

        RetrofitClient.service.getGitList().enqueue(object : Callback<List<GitResponse>> {
            override fun onResponse(
                call: Call<List<GitResponse>>,
                response: Response<List<GitResponse>>
            ) {
                when {
                    response.isSuccessful -> {

                        val gitMutableList: MutableList<Git> = mutableListOf()

                        response.body()?.let { gitResponseList ->
                            for (itemGitReponse in gitResponseList) {
                                gitMutableList.add(itemGitReponse.getGitModel())
                            }
                        }

                        gitMutableLiveData.value = gitMutableList
                    }
                }
            }

            override fun onFailure(call: Call<List<GitResponse>>, t: Throwable) {
                gitMutableLiveData.value = null
            }
        })
    }
}
