package com.example.simplenotepad.noteFeatures.data.repository

import com.example.simplenotepad.noteFeatures.data.dataSource.noteDao
import com.example.simplenotepad.noteFeatures.domain.model.Note
import kotlinx.coroutines.flow.Flow

class noteRepositoryImplementation(
    private val dao: noteDao
) : noteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getById(id: Int): Note? {
        return dao.getById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}