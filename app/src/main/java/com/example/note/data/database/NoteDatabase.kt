package com.example.note.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.note.data.Note
import com.example.note.data.NoteDao

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        @Volatile
        private var instanse: NoteDatabase? = null
        val lock = Any()

        operator fun invoke(context: Context) = instanse ?: synchronized(lock) {
            instanse ?: createDatabase(context).also { it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext, NoteDatabase::class.java, "Database"
            ).build()

    }
}