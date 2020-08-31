package com.example.challengeambar.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeambar.R
import com.example.challengeambar.data.model.Git
import com.example.challengeambar.databinding.ItemListBinding

class MyAdapter(
    private val gits: List<Git>,
    val onClickListener: (Git) -> Unit
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val git = gits[position]
        viewHolder.binding.git = git
        viewHolder.binding.root.setOnClickListener {
            onClickListener.invoke(git)
        }
    }

    override fun getItemCount() = gits.size

    inner class MyViewHolder constructor(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
}

