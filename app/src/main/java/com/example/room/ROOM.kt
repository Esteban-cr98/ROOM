package com.example.room

import android.app.Application
import androidx.room.Room
import com.example.room.model.DeudorDataBase
import com.example.room.model.RegistroDataBase

class ROOM : Application() {

    companion object{
        lateinit var database:DeudorDataBase

        lateinit var database2:RegistroDataBase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            DeudorDataBase ::class.java,
            "misdeudores_db"
        ).allowMainThreadQueries()
            .build()

        database2 = Room.databaseBuilder(
            this,
            RegistroDataBase ::class.java,
            "registros_db"
        ).allowMainThreadQueries()
            .build()
    }

}