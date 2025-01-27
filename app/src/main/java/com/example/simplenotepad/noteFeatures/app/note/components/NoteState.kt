package com.example.simplenotepad.noteFeatures.app.note.components

import com.example.simplenotepad.noteFeatures.domain.model.Note
import com.example.simplenotepad.noteFeatures.domain.util.OrderType
import com.example.simplenotepad.noteFeatures.domain.util.noteOrder

data class NoteState(
    val notes: List<Note> = emptyList(),
    val NoteOrder: noteOrder = noteOrder.Date(OrderType.descending),
    val isOrderSectionVisible: Boolean = false
)
