package com.rsamqui.transactions.dao

import androidx.room.*
import com.rsamqui.transactions.entities.GeneroEntity

@Dao
interface GeneroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenero(genero:GeneroEntity)

    @Query("SELECT * FROM tbl_genero")
    suspend fun getAll(): List<GeneroEntity>

    @Query("SELECT * FROM tbl_genero WHERE idGenero= :id")
    suspend fun getGeneroById(id: Int): List<GeneroEntity>

    @Update
    fun update (genero:GeneroEntity)

    @Delete
    fun delete (genero:GeneroEntity)

}