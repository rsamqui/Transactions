package com.rsamqui.transactions.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tbl_genero")
data class Genero(
    @PrimaryKey(autoGenerate = true)
    val idGenero: Int,

    @ColumnInfo(name="nombre")
    var nombre: String,

    @ColumnInfo(name="activo")
    var activo: Boolean
)
