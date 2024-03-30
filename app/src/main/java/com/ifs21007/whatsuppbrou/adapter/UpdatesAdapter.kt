package com.ifs21007.whatsuppbrou.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.data.Updates
import com.ifs21007.whatsuppbrou.databinding.ItemRowUpdatesBinding

class UpdatesAdapter (private val listUpdates: ArrayList<Updates>): RecyclerView.Adapter<UpdatesAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUpdatesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val updates = listUpdates[position]
        holder.bind(updates)
    }

    override fun getItemCount(): Int = listUpdates.size

    inner class ListViewHolder(private val binding: ItemRowUpdatesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(updates: Updates) {
            with(binding) {
                tvNamaUp.text = updates.contact
                tvJam.text = updates.isi
                imageView.setImageResource(updates.icon)
            }
        }
    }
}