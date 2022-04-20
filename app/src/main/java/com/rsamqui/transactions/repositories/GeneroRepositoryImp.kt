package com.rsamqui.transactions.repositories

import com.rsamqui.transactions.dao.GeneroDao
import com.rsamqui.transactions.entities.Genero
import kotlinx.coroutines.flow.Flow

class GeneroRepositoryImp private constructor(
    private val generoDao: GeneroDao
): GeneroRepository{

    companion object {
        @Volatile
        private var INSTANCE : GeneroRepository? = null

        private fun createInstance() : GeneroRepository =
            GeneroRepositoryImp()

        operator fun invoke() : GeneroRepository =
            INSTANCE ?: synchronized(this) {
                createInstance()
            }.also {INSTANCE = it}
    }

    override suspend fun insertGenero(genero: Genero) {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): Flow<List<Genero>> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int): Genero {
        TODO("Not yet implemented")
    }

    override suspend fun updateGenero(genero: Genero) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteGenero(id: Int) {
        TODO("Not yet implemented")
    }
}