package com.example.simplenotepad.noteFeatures.app.noteFunctionalities.components

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvent{
    data class enteredTitle(val value: String): AddEditNoteEvent()
    data class changeTitleFocus(val focusState: FocusState): AddEditNoteEvent()
    data class enteredContent(val value: String): AddEditNoteEvent()
    data class changeContentFocus(val focusState: FocusState): AddEditNoteEvent()
    data class changeColor(val color: Int): AddEditNoteEvent()
    object saveNote: AddEditNoteEvent()

}
