package com.example.note.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.note.R
import com.example.note.databinding.FragmentEditBinding
import com.example.note.ui.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class EditFragment : Fragment(R.layout.fragment_edit) {

    val args: EditFragmentArgs by navArgs()

    private val viewModel: NoteViewModel by viewModels()

    private lateinit var binding: FragmentEditBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditBinding.bind(view)

        binding.edtPageTitle.setText(args.note.title)
        binding.edtPageDescription.setText(args.note.description)

        binding.editButton.setOnClickListener {

            val title = binding.edtPageTitle.text
            val description = binding.edtPageDescription.text

            if (title.isBlank() || description.isBlank()) {
                Toast.makeText(context, "please enter title and description", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            args.note.title = title.toString().trim()
            args.note.description = description.toString().trim()
            args.note.date = Calendar.getInstance().time
            viewModel.insert(args.note)

            Toast.makeText(context, "note edited", Toast.LENGTH_SHORT)

            findNavController().navigate(R.id.action_editFragment_to_mainListFragment)
        }

    }
}