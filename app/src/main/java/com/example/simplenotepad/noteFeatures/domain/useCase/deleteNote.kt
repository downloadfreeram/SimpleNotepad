package com.example.simplenotepad.noteFeatures.domain.useCase

import com.example.simplenotepad.noteFeatures.data.repository.noteRepository
import com.example.simplenotepad.noteFeatures.domain.model.Note

class deleteNote(
    private val repository: noteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}