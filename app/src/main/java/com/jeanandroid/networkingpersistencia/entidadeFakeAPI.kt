package com.jeanandroid.networkingpersistencia

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "JSONCESAR")
data class entidadeFakeAPI(@PrimaryKey @ColumnInfo(name = "name") val name : String, @ColumnInfo(name = "email") val email : String, @ColumnInfo(name = "body") val body : String)