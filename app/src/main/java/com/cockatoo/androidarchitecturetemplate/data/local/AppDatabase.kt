package com.cockatoo.androidarchitecturetemplate.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cockatoo.androidarchitecturetemplate.data.GenreConverters
import com.cockatoo.androidarchitecturetemplate.model.Brand

@Database(entities = [Brand::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun brandDao() : BrandDao
}