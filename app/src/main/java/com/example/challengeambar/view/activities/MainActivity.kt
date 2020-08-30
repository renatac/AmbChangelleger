package com.example.challengeambar.view.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeambar.R
import com.example.challengeambar.data.model.Git
import com.example.challengeambar.view.adapters.MyAdapter
import com.example.challengeambar.view.communs.BaseActivity
import com.example.challengeambar.viewmodel.GitViewModel
import com.example.challengeambar.viewmodel.GitViewModel.Companion.VIEW_FLIPPER_ERROR
import com.example.challengeambar.viewmodel.GitViewModel.Companion.VIEW_FLIPPER_GIT_LIST
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var viewModel: GitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(GitViewModel::class.java)

        viewModel.gitMutableLiveData.observe(this, Observer { gitList ->
            if (gitList == null) {
                viewFlipper.displayedChild = VIEW_FLIPPER_ERROR
            } else {
                viewFlipper.displayedChild = VIEW_FLIPPER_GIT_LIST
                displayRecycler(gitList)
            }
        })

        viewModel.getGitResponse()

    }

    private fun displayRecycler(gitList: List<Git>) {
        if (gitList.isNotEmpty()) {
            with(recyclerView) {
                layoutManager = LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL, false
                )
                setHasFixedSize(true)

                val urlList = mutableListOf<String>()
                for (index in 0 until gitList.size) {
                    urlList.add(gitList[index].url)
                }

                adapter = MyAdapter(gitList) {
                    val uri: Uri = Uri.parse(it.url)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }

            }
        }

    }
}
