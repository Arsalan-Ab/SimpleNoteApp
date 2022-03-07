package com.example.note.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(

    var title: String,
    var description: String,
    var date: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}