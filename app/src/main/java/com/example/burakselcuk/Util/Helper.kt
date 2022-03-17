package com.example.burakselcuk.Util

import com.example.burakselcuk.model.shipItem

class Helper {

    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var stationList = ArrayList<shipItem>()
            stationList.add(shipItem(300, 3,7,"burak",5,1000))
            stationList.add(shipItem(300, 3,7,"bozo",5,1000))
            stationList.add(shipItem(300, 3,7,"burak",5,1000))
            stationList.add(shipItem(300, 3,7,"burak",5,1000))
            stationList.add(shipItem(300, 3,7,"burak",5,1000))


            return stationList as ArrayList
        }
    }

}