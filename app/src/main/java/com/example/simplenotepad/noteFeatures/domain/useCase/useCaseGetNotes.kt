package com.example.simplenotepad.noteFeatures.domain.useCase

import com.example.simplenotepad.noteFeatures.data.repository.noteRepository
import com.example.simplenotepad.noteFeatures.domain.model.Note
import com.example.simplenotepad.noteFeatures.domain.util.OrderType
import com.example.simplenotepad.noteFeatures.domain.util.noteOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//allows to use test case when having more viewmodels, in order to prevent repeating the same code
class useCaseGetNotes(
    private val repository : noteRepository
) {
    operator fun invoke(
        NoteOrder: noteOrder = noteOrder.Date(OrderType.descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(NoteOrder.orderType) {
                is OrderType.ascending -> {
                    when(NoteOrder) {
                        is noteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is noteOrder.Date -> notes.sortedBy { it.timestamp }
                        is noteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.descending -> {
                    when(NoteOrder) {
                        is noteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is noteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is noteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}