package com.example.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_registros")
class Registro(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "correo")val correo: String,
    @ColumnInfo(name = "clave")val clave: String,
    @ColumnInfo(name = "nombre")val nombre: String,
    @ColumnInfo(name = "cedula")val cedula: String

) {
}