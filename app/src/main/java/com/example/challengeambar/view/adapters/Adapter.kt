package com.example.challengeambar.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeambar.R
import com.example.challengeambar.data.model.User
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(
    private val user: List<User>
//    val onItemClickListener: ((user: User) -> Unit)
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapter.MyViewHolder {

        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.bindView(user[position])
    }

    override fun getItemCount() = user.size

    class MyViewHolder(itemView: View
//                       , private val onItemClickListener: ((user: User)->Unit)
): RecyclerView.ViewHolder(itemView) {

        fun bindView(user: User){
            itemView.textName.text =  user.name
            itemView.textAuthor.text  = user.author

//            itemView.setOnClickListener{
//                onItemClickListener.invoke(user)
//            }
        }
    }
}

