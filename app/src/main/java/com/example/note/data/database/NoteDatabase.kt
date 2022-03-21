package com.example.note.data.database

import androidx.room.*
import com.example.note.converters.DateConverter
import com.example.note.data.Note
import com.example.note.data.NoteDao

@Database(entities = [Note::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}