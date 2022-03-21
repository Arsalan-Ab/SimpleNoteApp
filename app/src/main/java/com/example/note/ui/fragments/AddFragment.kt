package com.example.note.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.note.R
import com.example.note.data.Note
import com.example.note.databinding.FragmentAddBinding
import com.example.note.ui.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var binding: FragmentAddBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddBinding.bind(view)

        binding.btnSave.setOnClickListener {
            val title = binding.title.text.toString()
            val description = binding.Description.text.toString()

            if (title.isBlank() || description.isBlank()) {
                Toast.makeText(context, "please enter title and description", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val note = Note(title.trim(), description.trim(), Calendar.getInstance().time)
            viewModel.insert(note)

            Toast.makeText(context, "Note Saved", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_editFragment_to_mainListFragment)
        }

    }
}