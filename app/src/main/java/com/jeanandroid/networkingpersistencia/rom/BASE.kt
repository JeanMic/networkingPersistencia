package com.jeanandroid.networkingpersistencia.rom

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jeanandroid.networkingpersistencia.entidadeFakeAPI

@Database (entities = arrayOf(entidadeFakeAPI::class), version = 1, exportSchema = false)
abstract class BASE : RoomDatabase() {

    abstract fun entidadeDAO(): DAO

    companion object {
        var productDao: DAO? = null
    }

}