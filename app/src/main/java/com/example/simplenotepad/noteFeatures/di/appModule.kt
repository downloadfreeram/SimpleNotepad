package com.example.simplenotepad.noteFeatures.di

import android.app.Application
import androidx.room.Room
import com.example.simplenotepad.noteFeatures.data.dataSource.noteDB
import com.example.simplenotepad.noteFeatures.data.dataSource.noteDao
import com.example.simplenotepad.noteFeatures.data.repository.noteRepository
import com.example.simplenotepad.noteFeatures.data.repository.noteRepositoryImplementation
import com.example.simplenotepad.noteFeatures.domain.useCase.deleteNote
import com.example.simplenotepad.noteFeatures.domain.useCase.useCaseGetNotes
import com.example.simplenotepad.noteFeatures.domain.useCase.useCaseNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {
    @Provides
    @Singleton
    fun provideNoteDB(app : Application) : noteDB {
        return Room.databaseBuilder(
            app,
            noteDB::class.java,
            noteDB.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: noteDB): noteRepository {
        return noteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: noteRepository) : useCaseNote {
        return useCaseNote(
            getNotes = useCaseGetNotes(repository),
            delete = deleteNote(repository)
        )
    }
}