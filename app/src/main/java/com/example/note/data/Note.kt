package com.example.note.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note_table")
data class Note(

    var title: String,
    var description: String,
    var date: Date
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}