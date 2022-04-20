package com.rsamqui.transactions.dao

import androidx.room.*
import com.rsamqui.transactions.entities.Genero

@Dao
interface GeneroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenero(genero:Genero)

    @Query("SELECT * FROM tbl_genero")
    suspend fun getAll(): List<Genero>

    @Query("SELECT * FROM tbl_genero WHERE idGenero= :id")
    suspend fun getGeneroById(id: Int): List<Genero>

    @Update
    fun update (genero:Genero)

    @Delete
    fun delete (genero:Genero)

}