package com.example.simplenotepad.noteFeatures.data.dataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplenotepad.noteFeatures.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class noteDB: RoomDatabase() {
    abstract val noteDao: noteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}