package com.ifs21007.whatsuppbrou.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.data.Chat
import com.ifs21007.whatsuppbrou.databinding.ItemRowChatBinding

class ChatAdapter (private val listChats: ArrayList<Chat>) : RecyclerView.Adapter<ChatAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val chats = listChats[position]
        holder.bind(chats)
    }

    override fun getItemCount(): Int = listChats.size

    inner class ListViewHolder(private val binding: ItemRowChatBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            with(binding) {
                tvNamaChat.text = chat.contact
                tvIsiChat.text = chat.isi
                imageView.setImageResource(chat.icon)
            }
        }
    }
}