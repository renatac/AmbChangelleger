package com.example.challengeambar.view.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeambar.R
import com.example.challengeambar.data.model.Git
import com.example.challengeambar.databinding.ItemListBinding
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(
    private val gits: List<Git>,
    val onClickListener: (Git) -> Unit
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var index = -1

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
        viewHolder.itemView.rankingPosition.text = (position + 1).toString()

        viewHolder.binding.root.setOnClickListener {
            index = position
            notifyDataSetChanged()
            onClickListener.invoke(git)
        }

        if (index == position) {
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#8FBC8F"))
        } else {
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
        }

    }

    override fun getItemCount() = gits.size

    inner class MyViewHolder constructor(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
}
