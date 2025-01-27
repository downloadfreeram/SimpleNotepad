package com.example.simplenotepad.noteFeatures.app.note.components

import com.example.simplenotepad.noteFeatures.domain.model.Note
import com.example.simplenotepad.noteFeatures.domain.util.noteOrder

sealed class NotesEvent {
    data class Order(val NoteOrder: noteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}