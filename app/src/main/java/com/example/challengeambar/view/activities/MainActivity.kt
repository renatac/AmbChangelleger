package com.example.challengeambar.view.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeambar.R
import com.example.challengeambar.data.model.User
import com.example.challengeambar.view.adapters.MyAdapter
import com.example.challengeambar.view.communs.BaseActivity
import com.example.challengeambar.viewmodel.viewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(viewModel::class.java)

        with(recyclerView) {
            layoutManager = LinearLayoutManager(
                context,
                RecyclerView.VERTICAL, false
            )
            setHasFixedSize(true)

            val fakeUser: List<User> = listOf(
                User("GitTest 0", "Author 0"),
            User("GitTest 1", "Author 1"),
            User("GitTest 2", "Author 2"),
            User("GitTest 3", "Author 3"),
            User("GitTest 4", "Author 4"),
            User("GitTest 5", "Author 5"),
            User("GitTest 6", "Author 6"),
            User("GitTest 7", "Author 7"),
            User("GitTest 8", "Author 8"),
            User("GitTest 9", "Author 9"),
            User("GitTest 10", "Author 10"))

            adapter = MyAdapter(fakeUser)
        }
    }
}
