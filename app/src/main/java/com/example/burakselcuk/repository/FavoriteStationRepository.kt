package com.example.burakselcuk.repository

import androidx.lifecycle.LiveData
import com.example.burakselcuk.db.FavoriteDao
import com.example.burakselcuk.model.ship
import com.example.burakselcuk.model.shipItem
import javax.inject.Inject

class FavoriteStationRepository @Inject constructor(private val dao:FavoriteDao){

    suspend fun insertStation(station: shipItem)=dao.insertStation(station)
    suspend fun deleteStation(station: shipItem)=dao.deleteStation(station)
    val readAllData: LiveData<List<shipItem>> = dao.getAllStation()

}