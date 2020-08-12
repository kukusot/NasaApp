package com.ikukushev.nasaapp.pictures.apod.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ikukushev.nasaapp.pictures.apod.data.ApodRoomEntity

@Dao
interface ApodDao {

    @Query("SELECT * FROM apod")
    suspend fun getAll(): List<ApodRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApod(apod: ApodRoomEntity)
}