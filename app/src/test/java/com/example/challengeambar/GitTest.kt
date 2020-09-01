package com.example.challengeambar

import com.example.challengeambar.data.Response.GitResponse
import com.example.challengeambar.data.Response.OwnerResponse
import com.example.challengeambar.data.model.Git
import org.junit.Assert
import org.junit.Test

class GitTest {

    @Test
    fun `test relation between Git and GitResponse`() {

        val gitResponseMutableList: MutableList<GitResponse> = mutableListOf()

        for (index in 0 until 3) {
            val gitResponse = GitResponse(
                repositoryName = "Qualquer",
                owner = OwnerResponse("Eu"),
                url = "http://www.renatarcs7@gmail.com"
            )
            gitResponseMutableList.add(gitResponse)
        }

        val git = Git(
            name = "Qualquer",
            author = "Eu",
            url = "http://www.renatarcs7@gmail.com"
        )

        Assert.assertEquals(gitResponseMutableList[0].repositoryName, git.name)
        Assert.assertEquals(gitResponseMutableList[0].owner.author, git.author)
        Assert.assertEquals(gitResponseMutableList[0].url, git.url)
    }

}