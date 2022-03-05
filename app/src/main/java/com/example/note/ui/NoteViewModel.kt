package com.example.note.ui

import androidx.lifecycle.ViewModel
import com.example.note.data.Note
import com.example.note.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    fun insert(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(note)
    }

    fun delete(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(note)
    }

    fun getAllNote() = repository.getAllNote()

}
