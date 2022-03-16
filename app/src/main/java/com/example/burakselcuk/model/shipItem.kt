package com.example.burakselcuk.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "station_data")
data class shipItem(
    @PrimaryKey(autoGenerate = true)
    val capacity: Int,
    val coordinateX: Int,
    val coordinateY: Int,
    val name: String,
    val need: Int,
    val stock: Int
):Serializable