package com.example.burakselcuk.repository

import com.example.burakselcuk.service.ShipApi
import javax.inject.Inject

class shipRepository @Inject constructor(private val shipApi: ShipApi) {

    suspend fun getShipes()=shipApi.getShipList()

}