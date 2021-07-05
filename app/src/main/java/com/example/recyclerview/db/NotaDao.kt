package com.example.recyclerview.db

import androidx.room.*

@Dao
interface NotaDao {
    @Query("SELECT * FROM Nota")
    fun obtenerTodas():List<Nota>

    @Query("SELECT * FROM Nota WHERE id=:id")
    suspend fun getById(id:Int):Nota

    @Update
    suspend fun update(nota: Nota)

    @Insert
    suspend fun insert(notas:List<Nota>)

    @Delete
    suspend fun delete(nota: Nota)
}