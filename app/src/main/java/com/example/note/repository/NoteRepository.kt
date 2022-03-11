package com.example.note.repository

import com.example.note.data.Note
import com.example.note.data.NoteDao
import com.example.note.data.database.NoteDatabase
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dao: NoteDao
) {
    suspend fun insert(note: Note) = dao.insert(note)

    suspend fun delete(note :Note) = dao.delete(note)

    fun getAllNote() = dao.getAllNote()
}