package com.jeanandroid.networkingpersistencia.rom

import android.arch.persistence.room.*
import com.jeanandroid.networkingpersistencia.entidadeFakeAPI

@Dao
interface DAO {

    @Query("SELECT * FROM JSONCESAR")
    fun getAll(): List<entidadeFakeAPI>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entidades: ArrayList<entidadeFakeAPI>)

    @Delete
    fun deleteAll(vararg entidades: entidadeFakeAPI)

}