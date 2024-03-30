package com.ifs21007.whatsuppbrou.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.R
import com.ifs21007.whatsuppbrou.adapter.CallAdapter
import com.ifs21007.whatsuppbrou.data.Call
import com.ifs21007.whatsuppbrou.databinding.FragmentLogcallBinding

class LogcallFragment : Fragment() {
    private lateinit var adapter: CallAdapter
    private lateinit var recyclerView: RecyclerView
    private val dataCall = ArrayList<Call>()
    private lateinit var binding: FragmentLogcallBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogcallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        getChat()
    }
    private fun setupRecyclerView() {
        adapter = CallAdapter(dataCall)
        recyclerView = binding.root.findViewById(R.id.rvLogCall)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun getChat(): ArrayList<Call> {
        val dataIcon = resources.obtainTypedArray( R.array.chat)
        val dataKontak = resources.getStringArray(R.array.namechat)
        val dataIsiChat = resources.getStringArray(R.array.statusCall)

        for (i in dataKontak.indices) {
            val call = Call(dataIcon.getResourceId(i, -1), dataKontak[i], dataIsiChat[i])
            dataCall.add(call)
        }
        return dataCall
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
