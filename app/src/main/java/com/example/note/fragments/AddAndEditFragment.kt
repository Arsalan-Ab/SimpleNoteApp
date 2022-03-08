package com.example.note.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.note.R
import com.example.note.data.Note
import com.example.note.databinding.FragmentAddAndEditBinding
import java.text.SimpleDateFormat
import java.util.*

class AddAndEditFragment : Fragment(R.layout.fragment_add_and_edit) {

    private lateinit var binding: FragmentAddAndEditBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddAndEditBinding.bind(view)

        binding.btnSave.setOnClickListener {
            val title = binding.title.text.toString()
            val description = binding.Description.text.toString()

            if (title.isEmpty() || description.isEmpty()){
                Toast.makeText(context, "pls enter something", Toast.LENGTH_SHORT).show()
            }
            val date = SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().time)
            val note = Note(title,description,date)
        }

    }
}