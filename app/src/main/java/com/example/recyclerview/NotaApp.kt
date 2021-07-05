package com.example.recyclerview

import android.app.Application
import androidx.room.Room
import com.example.recyclerview.db.NotasDB

class NotaApp: Application() {
        val room = Room
            .databaseBuilder(this,NotasDB::class.java,"notas_db")
            .build()


}