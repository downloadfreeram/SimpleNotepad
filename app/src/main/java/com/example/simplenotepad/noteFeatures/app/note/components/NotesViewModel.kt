package com.example.simplenotepad.noteFeatures.app.note.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenotepad.noteFeatures.domain.model.Note
import com.example.simplenotepad.noteFeatures.domain.useCase.useCaseNote
import com.example.simplenotepad.noteFeatures.domain.util.OrderType
import com.example.simplenotepad.noteFeatures.domain.util.noteOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCaseNote: useCaseNote
) : ViewModel() {

    private val  _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNoteJob: Job? = null

    init {
        getNotes(noteOrder.Date(OrderType.descending))
    }

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.Order -> {
                if(state.value.NoteOrder::class == event.NoteOrder::class &&
                    state.value.NoteOrder.orderType == event.NoteOrder.orderType) {
                    return
                }
                getNotes(event.NoteOrder)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    useCaseNote.delete(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    useCaseNote.add(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(NoteOrder: noteOrder) {
        getNoteJob?.cancel()
        getNoteJob = useCaseNote.getNotes(NoteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    NoteOrder = NoteOrder
                )
            }
            .launchIn(viewModelScope)
    }
}