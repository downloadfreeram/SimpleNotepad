package com.example.simplenotepad.noteFeatures.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simplenotepad.ui.theme.BabyBlue
import com.example.simplenotepad.ui.theme.LightGreen
import com.example.simplenotepad.ui.theme.RedOrange
import com.example.simplenotepad.ui.theme.RedPink
import com.example.simplenotepad.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, RedPink, BabyBlue, Violet, LightGreen)
    }
}

class  InvalidNoteException(message : String): Exception(message)