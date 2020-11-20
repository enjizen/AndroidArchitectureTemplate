package com.cockatoo.androidarchitecturetemplate.data.local

import androidx.room.*
import com.cockatoo.androidarchitecturetemplate.model.Brand

@Dao
interface BrandDao {

    @Query("SELECT * FROM brand")
    fun getAll(): List<Brand>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(brandList: List<Brand>)

    @Delete
    fun delete(brand: Brand)

    @Delete
    fun deleteAll(brandList: List<Brand>)
}