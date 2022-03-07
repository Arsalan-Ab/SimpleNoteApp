package com.example.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.note.data.Note
import com.example.note.databinding.NoteListBinding
import com.example.note.ui.NoteViewModel
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapter(
    var notes: List<Note>,
    private val viewModel: NoteViewModel
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NoteListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.txtTitle.text = notes[position].title

        holder.binding.txtDescription.text = notes[position].description

        holder.binding.txtDate.text = notes[position].date

        holder.binding.delete.setOnClickListener {
            viewModel.delete(notes[position])
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}