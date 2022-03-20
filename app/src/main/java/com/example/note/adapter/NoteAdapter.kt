package com.example.note.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.note.data.Note
import com.example.note.databinding.NoteListBinding
import com.example.note.ui.NoteViewModel
import java.text.SimpleDateFormat


class NoteAdapter(
    var notes: List<Note>,
    private val viewModel: NoteViewModel,
    private val listener: onItemClickListener
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

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

        holder.binding.txtDate.text =
            SimpleDateFormat("dd/MM/yyyy HH:mm").format(notes[position].date.time)

        holder.binding.delete.setOnClickListener {
            viewModel.delete(notes[position])
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class NoteViewHolder(val binding: NoteListBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(notes[adapterPosition])
            }
        }
    }

    interface onItemClickListener {
        fun onItemClick(note: Note)
    }

}