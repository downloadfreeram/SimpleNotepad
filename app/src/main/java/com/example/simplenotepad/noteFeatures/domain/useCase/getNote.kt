package com.example.simplenotepad.noteFeatures.domain.useCase

import com.example.simplenotepad.noteFeatures.data.repository.noteRepository
import com.example.simplenotepad.noteFeatures.domain.model.Note

class getNote(
    private val repository: noteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getById(id)
    }
}