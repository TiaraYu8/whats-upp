package com.ifs21007.whatsuppbrou.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.R
import com.ifs21007.whatsuppbrou.adapter.ChatAdapter
import com.ifs21007.whatsuppbrou.data.Chat
import com.ifs21007.whatsuppbrou.databinding.FragmentChattingBinding

class ChattingFragment : Fragment() {
    private lateinit var adapter: ChatAdapter
    private lateinit var recyclerView: RecyclerView
    private val dataChat = ArrayList<Chat>()
    private lateinit var binding: FragmentChattingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChattingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        getChat()
    }

    private fun setupRecyclerView() {
        adapter = ChatAdapter(dataChat)
        recyclerView = binding.root.findViewById(R.id.rvChat)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun getChat(): ArrayList<Chat> {
        val dataIcon = resources.obtainTypedArray( R.array.chat)
        val dataKontak = resources.getStringArray(R.array.namechat)
        val dataIsiChat = resources.getStringArray(R.array.isichat)

        for (i in dataKontak.indices) {
            val chat = Chat(dataIcon.getResourceId(i, -1), dataKontak[i], dataIsiChat[i])
            dataChat.add(chat)
        }
        return dataChat
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
