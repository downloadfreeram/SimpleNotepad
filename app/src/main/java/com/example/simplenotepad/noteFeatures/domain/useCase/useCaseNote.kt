package com.example.simplenotepad.noteFeatures.domain.useCase

data class useCaseNote(
    val getNotes: useCaseGetNotes,
    val delete : deleteNote,
    val add : addNote,
    val getNote: getNote
)