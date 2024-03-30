package com.ifs21007.whatsuppbrou.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifs21007.whatsuppbrou.R
import com.ifs21007.whatsuppbrou.adapter.CommunitiesAdapter
import com.ifs21007.whatsuppbrou.data.Comunities
import com.ifs21007.whatsuppbrou.databinding.FragmentCommunitiesBinding

class CommunitiesFragment : Fragment() {
    private lateinit var adapter: CommunitiesAdapter
    private lateinit var recyclerView: RecyclerView
    private val dataComunities = ArrayList<Comunities>()
    private lateinit var binding: FragmentCommunitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        getChat()
    }
    private fun setupRecyclerView() {
        adapter = CommunitiesAdapter(dataComunities)
        recyclerView = binding.root.findViewById(R.id.rvComunities)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun getChat(): ArrayList<Comunities> {
        val dataIcon = resources.obtainTypedArray( R.array.chatKom)
        val dataKontak = resources.getStringArray(R.array.nameCom)
        val dataIsiChat = resources.getStringArray(R.array.isichat)

        for (i in dataKontak.indices) {
            val comunities = Comunities(dataIcon.getResourceId(i, -1), dataKontak[i], dataIsiChat[i])
            dataComunities.add(comunities)
        }
        return dataComunities
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }
}
