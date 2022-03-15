package com.example.burakselcuk.service

import com.example.burakselcuk.model.ship
import retrofit2.Response
import retrofit2.http.GET

interface ShipApi {

    //Get all Stations
    @GET("v3/e7211664-cbb6-4357-9c9d-f12bf8bab2e2")
    suspend fun getShipList():Response<ship>
}