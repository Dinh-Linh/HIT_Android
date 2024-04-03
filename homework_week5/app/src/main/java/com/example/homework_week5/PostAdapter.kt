package com.example.homework_week5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(val listPost: MutableList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avt = itemView.findViewById<ImageView>(R.id.avt)
        val image1 = itemView.findViewById<ImageView>(R.id.imagePost)
        val name = itemView.findViewById<TextView>(R.id.name)
        val address = itemView.findViewById<TextView>(R.id.address)
        val react = itemView.findViewById<ImageView>(R.id.react)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = listPost[position]
        holder.name.text = listPost[position].name
        holder.address.text = listPost[position].address
        Glide.with(holder.itemView.context)
            .load(post.image)
            .into(holder.image1)
        Glide.with(holder.itemView.context).load(post.avt).into(holder.avt)

    }

    override fun getItemCount(): Int = listPost.size

}