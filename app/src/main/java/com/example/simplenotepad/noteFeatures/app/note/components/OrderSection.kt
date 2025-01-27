package com.example.simplenotepad.noteFeatures.app.note.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplenotepad.noteFeatures.domain.util.OrderType
import com.example.simplenotepad.noteFeatures.domain.util.noteOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    NoteOrder: noteOrder = noteOrder.Date(OrderType.descending),
    onOrderChange: (noteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = NoteOrder is noteOrder.Title ,
                onSelect = { onOrderChange(noteOrder.Title(NoteOrder.orderType)) }
                )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = NoteOrder is noteOrder.Date ,
                onSelect = { onOrderChange(noteOrder.Date(NoteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Color",
                selected = NoteOrder is noteOrder.Color ,
                onSelect = { onOrderChange(noteOrder.Color(NoteOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = NoteOrder.orderType is OrderType.ascending ,
                onSelect = {
                    onOrderChange(NoteOrder.copy(OrderType.ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = NoteOrder.orderType is OrderType.descending ,
                onSelect = {
                    onOrderChange(NoteOrder.copy(OrderType.descending))
                }
            )
        }
    }
}