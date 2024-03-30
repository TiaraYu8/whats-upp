package com.ifs21007.whatsuppbrou.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.data.Call
import com.ifs21007.whatsuppbrou.databinding.ItemRowLogcallBinding

class CallAdapter (private val listCalls: ArrayList<Call>) : RecyclerView.Adapter<CallAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowLogcallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val call = listCalls[position]
        holder.bind(call)
    }

    override fun getItemCount(): Int = listCalls.size

    inner class ListViewHolder(private val binding: ItemRowLogcallBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(call: Call) {
            with(binding) {
                tvLogCall.text = call.contact
                tvIsiLogCall.text = call.isi
                imageView.setImageResource(call.icon)
            }
        }
    }
}