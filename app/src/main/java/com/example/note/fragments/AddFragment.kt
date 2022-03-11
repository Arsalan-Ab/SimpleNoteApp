package com.example.note.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.note.R
import com.example.note.data.Note
import com.example.note.databinding.FragmentAddAndEditBinding
import com.example.note.ui.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class AddFragment : Fragment(R.layout.fragment_add_and_edit) {

    private lateinit var binding: FragmentAddAndEditBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddAndEditBinding.bind(view)

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
        }

    }
}