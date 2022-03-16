package com.example.burakselcuk.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.burakselcuk.model.ship
import com.example.burakselcuk.model.shipItem

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStation(station: shipItem)

    @Delete
    suspend fun deleteStation(station: shipItem)

    @Query("SELECT * FROM station_data ORDER BY name ASC ")
    fun getAllStation(): LiveData<List<shipItem>>

}