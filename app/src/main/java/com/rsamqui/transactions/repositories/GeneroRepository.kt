package com.rsamqui.transactions.repositories

import com.rsamqui.transactions.entities.Genero
import kotlinx.coroutines.flow.Flow

interface GeneroRepository {

    suspend fun insertGenero(genero: Genero)

    suspend fun getAll(): Flow<List<Genero>>

    suspend fun getById(id: Int): Genero

    suspend fun updateGenero(genero: Genero)

    suspend fun deleteGenero(id: Int)

}