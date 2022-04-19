package com.rsamqui.transactions.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rsamqui.transactions.dao.GeneroDao
import com.rsamqui.transactions.entities.GeneroEntity

interface MainDataBaseProvider{
    fun generoDao() : GeneroDao
}

@Database (entities = [GeneroEntity::class],
    version = 1
)

abstract class DBGenero: RoomDatabase(), MainDataBaseProvider{
    abstract override fun generoDao(): GeneroDao

        companion object{
            @Volatile
            private var INSTANCE: DBGenero? =null

            fun getInstace (context: Context):DBGenero{
                synchronized(this){
                    var instance = INSTANCE
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            DBGenero::class.java,
                            "genero_main_db"
                        ).fallbackToDestructiveMigration()
                            .build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }

        }
}