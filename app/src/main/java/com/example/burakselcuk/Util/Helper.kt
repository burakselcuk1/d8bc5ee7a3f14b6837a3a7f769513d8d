package com.example.burakselcuk.Util

import com.example.burakselcuk.model.shipItem

class Helper {

    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var stationList = ArrayList<shipItem>()
            stationList.add(shipItem(300, 3,7,"DÜNYA",5,1000))
            stationList.add(shipItem(300, 3,7,"TCRKL289",5,1000))
            stationList.add(shipItem(300, 3,7,"MUKLSXCV",5,1000))
            stationList.add(shipItem(300, 3,7,"BRNANDOK",5,1000))
            stationList.add(shipItem(300, 3,7,"SKLMERCN",5,1000))
            stationList.add(shipItem(300, 3,7,"ALPMRTKN",5,1000))
            stationList.add(shipItem(300, 3,7,"MRTANDOP",5,1000))
            stationList.add(shipItem(300, 3,7,"IBRKAL",5,1000))
            stationList.add(shipItem(300, 3,7,"GKOLSKET",5,1000))
            return stationList as ArrayList
        }
    }
}