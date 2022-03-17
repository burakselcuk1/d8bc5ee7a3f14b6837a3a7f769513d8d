package com.example.burakselcuk.Util

import com.example.burakselcuk.model.shipItem

class Helper {

    //
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var stationList = ArrayList<shipItem>()
            stationList.add(shipItem(0, 0,0,"DÜNYA",0,1000))
            stationList.add(shipItem(5000, -2,4,"TCRKL289",3000,2000))
            stationList.add(shipItem(10000, -3,7,"MUKLSXCV",5000,5000))
            stationList.add(shipItem(10000, 2,1,"BRNANDOK",1000,9000))
            stationList.add(shipItem(3000, 2,5,"SKLMERCN",2000,1000))
            stationList.add(shipItem(14000, 5,8,"ALPMRTKN",12000,2000))
            stationList.add(shipItem(10000, 7,3,"MRTANDOP",1000,9000))
            stationList.add(shipItem(15000, 10,8,"IBRKAL",12000,3000))
            stationList.add(shipItem(10000, 12,6,"GKOLSKET",8000,2000))
            return stationList as ArrayList
        }
    }
}