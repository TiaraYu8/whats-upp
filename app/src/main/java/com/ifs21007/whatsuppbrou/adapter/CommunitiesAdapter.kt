package com.ifs21007.whatsuppbrou.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.data.Comunities
import com.ifs21007.whatsuppbrou.databinding.ItemRowComBinding

class CommunitiesAdapter (private val listCommunities: ArrayList<Comunities>) : RecyclerView.Adapter<CommunitiesAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowComBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val comunities = listCommunities[position]
        holder.bind(comunities)
    }

    override fun getItemCount(): Int = listCommunities.size

    inner class ListViewHolder(private val binding: ItemRowComBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comunities: Comunities) {
            with(binding) {
                tvNamaCom.text = comunities.contact
                tvIsiChatCom.text = comunities.isi
                imageView.setImageResource(comunities.icon)
            }
        }
    }
}