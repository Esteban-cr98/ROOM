package com.example.room.model

import androidx.room.*

@Dao
interface RegistroDAO {
    @Insert
    fun crearRegistro(registro: Registro)

    //@Query("SELECT * FROM tabla_registros WHERE correo LIKE :correo")
    @Query("SELECT * FROM tabla_registros WHERE correo LIKE:correo")
    fun buscarRegistro(correo:String) : Registro

    @Update
    fun actualizarRegistro(registro: Registro)

}