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

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(context, "please enter title and description", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val date = SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().time)
            val note = Note(title, description, date)
            viewModel.insert(note)

            Toast.makeText(context, "Note saved", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addAndEditFragment_to_mainListFragment)
        }

    }
}