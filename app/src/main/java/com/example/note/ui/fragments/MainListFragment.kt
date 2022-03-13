package com.example.note.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.R
import com.example.note.adapter.NoteAdapter
import com.example.note.data.Note
import com.example.note.databinding.FragmentMainListBinding
import com.example.note.ui.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainListFragment : Fragment(R.layout.fragment_main_list), NoteAdapter.onItemClickListener {

    private lateinit var binding: FragmentMainListBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainListBinding.bind(view)

        val adapter = NoteAdapter(listOf(), viewModel, this)

        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter

        viewModel.getAllNote().observe(viewLifecycleOwner, Observer {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_mainListFragment_to_addFragment)
        }
    }

    override fun onItemClick(note: Note) {
        val action = MainListFragmentDirections.actionMainListFragmentToEditFragment(note)
        findNavController().navigate(action)
    }

}