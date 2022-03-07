package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.adapter.NoteAdapter
import com.example.note.data.database.NoteDatabase
import com.example.note.databinding.ActivityNoteBinding
import com.example.note.repository.NoteRepository
import com.example.note.ui.NoteViewModel
import com.example.note.ui.ViewModelFactory
import java.util.*

class MainNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = NoteDatabase(this)
        val repository = NoteRepository(database)
        val factory = ViewModelFactory(repository)

        val viewModel = ViewModelProvider(this,factory).get(NoteViewModel::class.java)

        val adapter = NoteAdapter(listOf(),viewModel)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        viewModel.getAllNote().observe(this, Observer{
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })


    }
}