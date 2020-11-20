package com.cockatoo.androidarchitecturetemplate.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "brand")
data class Brand (
    @NotNull
    @PrimaryKey
    val id: Int?,
    @ColumnInfo(name = "name_thai")
    val nameThai: String?,
    @ColumnInfo(name = "name_english")
    val nameEnglish: String?,
    @ColumnInfo(name = "car_type_id")
    val carTypeId: String?
)