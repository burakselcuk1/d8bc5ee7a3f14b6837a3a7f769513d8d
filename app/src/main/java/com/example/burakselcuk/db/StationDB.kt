package com.example.burakselcuk.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.burakselcuk.model.ship
import com.example.burakselcuk.model.shipItem


@Database(entities = [shipItem::class], version = 1, exportSchema = false)
abstract class StationDB: RoomDatabase() {

    abstract fun FavoriteDao():FavoriteDao

}