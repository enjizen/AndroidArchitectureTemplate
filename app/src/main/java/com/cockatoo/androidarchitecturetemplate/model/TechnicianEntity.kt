package com.cockatoo.androidarchitecturetemplate.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "technician")
data class TechnicianEntity (
    @NotNull
    @PrimaryKey
    val id: Int,
    val name: String,
    val email: String,
    val tel: String,
    @ColumnInfo(name = "mobile_number")
    val mobileNumber: String
)