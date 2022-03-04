package com.example.note.repository

import com.example.note.data.Note
import com.example.note.data.database.NoteDatabase

class NoteRepository(
    private val db: NoteDatabase
) {
    suspend fun insert(note: Note) = db.getNoteDao().insert(note)

    suspend fun delete(note :Note) = db.getNoteDao().delete(note)

    fun getAllNote() = db.getNoteDao().getAllNote()
}