package com.example.note.di

import android.app.Application
import androidx.room.Room
import com.example.note.converters.DateConverter
import com.example.note.data.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, NoteDatabase::class.java, "note_database").build()

    @Provides
    fun provideNoteDao(db: NoteDatabase) = db.getNoteDao()
}