package com.example.note.ui

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.note.data.Note
import com.example.note.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
     val repository: NoteRepository
) : ViewModel() {

    fun insert(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.insert(note)
    }

    fun delete(note: Note) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(note)
    }

    fun getAllNote() = repository.getAllNote()

}
