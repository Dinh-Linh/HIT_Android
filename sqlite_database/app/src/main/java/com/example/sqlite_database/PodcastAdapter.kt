package com.example.sqlite_database

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PodcastAdapter(var list: MutableList<Podcast>, mainActivity: MainActivity) : RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder>() {
    class PodcastViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name_item)
        val image = itemView.findViewById<ImageView>(R.id.image_item)
        val author = itemView.findViewById<TextView>(R.id.author_item)
        val id_item = itemView.findViewById<TextView>(R.id.id_item)
        val duration = itemView.findViewById<TextView>(R.id.duration_item)
        val gerne = itemView.findViewById<TextView>(R.id.gerne_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_podcast, parent, false)
        return PodcastViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.author.text = list[position].author
        holder.duration.text = list[position].duration
        holder.id_item.text = list[position].id.toString()
        holder.gerne.text = list[position].genre
        Glide.with(holder.itemView.context).load(list[position].image).into(holder.image)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(newPodcast: MutableList<Podcast>) {
        list = newPodcast
        notifyDataSetChanged()
    }

}