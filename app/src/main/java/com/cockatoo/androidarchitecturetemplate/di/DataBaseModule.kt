package com.cockatoo.androidarchitecturetemplate.di

import android.content.Context
import androidx.room.Room
import com.cockatoo.androidarchitecturetemplate.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun  provideAppDataBase(@ApplicationContext appContext: Context) : AppDatabase = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "app.db"
    ).build()
}