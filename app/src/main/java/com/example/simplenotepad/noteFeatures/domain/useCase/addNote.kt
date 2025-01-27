package com.example.simplenotepad.noteFeatures.domain.useCase

import com.example.simplenotepad.noteFeatures.data.repository.noteRepository
import com.example.simplenotepad.noteFeatures.domain.model.InvalidNoteException
import com.example.simplenotepad.noteFeatures.domain.model.Note

class addNote(
    private val repository: noteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of the note is empty!")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note is empty!")
        }
        repository.insertNote(note)
    }
}