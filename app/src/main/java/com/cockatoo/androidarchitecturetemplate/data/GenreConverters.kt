package com.cockatoo.androidarchitecturetemplate.data

import androidx.room.TypeConverter

class GenreConverters {
    @TypeConverter
    fun listToString(values: List<Int>): String {
        mutableListOf<String>().apply {
            values.forEach {
                add(it.toString())
            }
        }.run {
            return this.joinToString(",")
        }
    }

    @TypeConverter
    fun stringToList(value: String): List<Int> {
        mutableListOf<Int>().apply {
            value.split(",").forEach {
                add(it.toInt())
            }
        }.run {
            return this
        }
    }
}