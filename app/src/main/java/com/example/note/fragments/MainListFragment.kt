package com.example.note.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.R
import com.example.note.adapter.NoteAdapter
import com.example.note.data.Note
import com.example.note.data.database.NoteDatabase
import com.example.note.databinding.FragmentMainListBinding
import com.example.note.repository.NoteRepository
import com.example.note.ui.NoteViewModel
import com.example.note.ui.ViewModelFactory

class MainListFragment : Fragment(R.layout.fragment_main_list) {

    private lateinit var binding: FragmentMainListBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainListBinding.bind(view)

        val database = NoteDatabase(requireContext())
        val repository = NoteRepository(database)
        val factory = ViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)
        val adapter = NoteAdapter(listOf(), viewModel)

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        viewModel.getAllNote().observe(viewLifecycleOwner, Observer {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })
    }

}