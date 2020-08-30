package com.example.challengeambar.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeambar.R
import com.example.challengeambar.data.model.Git
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(
    private val gits: List<Git>,
    val onItemClickListener: ((git:Git) -> Unit)
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    fun teste(): String { return "teste"}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapter.MyViewHolder {

        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return MyViewHolder(textView, onItemClickListener)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        val p = position
        viewHolder.bindView(gits[position])
    }

    override fun getItemCount() = gits.size


    class MyViewHolder(
        itemView: View, private val onItemClickListener: ((git: Git)->Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(git: Git) {
            itemView.textName.text = git.name
            itemView.textAuthor.text = git.author

            itemView.setOnClickListener{
                onItemClickListener.invoke(git)
            }
        }
    }
}

