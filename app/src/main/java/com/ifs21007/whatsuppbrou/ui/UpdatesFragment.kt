package com.ifs21007.whatsuppbrou.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.R
import com.ifs21007.whatsuppbrou.adapter.UpdatesAdapter
import com.ifs21007.whatsuppbrou.data.Updates
import com.ifs21007.whatsuppbrou.databinding.FragmentUpdatesBinding

class UpdatesFragment : Fragment() {
    private lateinit var adapter: UpdatesAdapter
    private lateinit var recyclerView: RecyclerView
    private val dataUpdates = ArrayList<Updates>()
    private lateinit var binding: FragmentUpdatesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getChat()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = UpdatesAdapter(dataUpdates)
        recyclerView = binding.root.findViewById(R.id.rvUpdates)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun getChat(): ArrayList<Updates> {
        val dataIcon = resources.obtainTypedArray( R.array.chatKom)
        val dataKontak = resources.getStringArray(R.array.nameCom)
        val dataIsiChat = resources.getStringArray(R.array.jamStatus)

        for (i in dataKontak.indices) {
            val updates = Updates(dataIcon.getResourceId(i, -1), dataKontak[i], dataIsiChat[i])
            dataUpdates.add(updates)
        }
        return dataUpdates
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
