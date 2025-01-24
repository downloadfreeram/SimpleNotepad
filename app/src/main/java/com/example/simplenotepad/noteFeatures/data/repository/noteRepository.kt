package com.example.simplenotepad.noteFeatures.data.repository

import com.example.simplenotepad.noteFeatures.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface noteRepository {
    fun getNotes() : Flow<List<Note>>

    suspend fun getById(id : Int) : Note?

    suspend fun insertNote(note : Note)

    suspend fun deleteNote(note : Note)
}