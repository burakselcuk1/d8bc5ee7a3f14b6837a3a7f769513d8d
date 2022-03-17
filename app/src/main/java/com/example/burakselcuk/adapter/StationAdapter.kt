package com.example.burakselcuk.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.burakselcuk.R
import com.example.burakselcuk.model.ship
import com.example.burakselcuk.model.shipItem
import kotlinx.android.synthetic.main.ship_item.view.*


class StationAdapter(private val dataSet: ship) :
    RecyclerView.Adapter<StationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stationName: TextView
        val capacity: TextView
        val stationStock: TextView

        init {
            stationName = view.findViewById(R.id.stationName)
            capacity = view.findViewById(R.id.capacity)
            stationStock = view.findViewById(R.id.stationStock)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.ship_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.stationName.text = dataSet[position].name
        viewHolder.capacity.text = dataSet[position].capacity.toString()
        viewHolder.stationStock.text = dataSet[position].stock.toString()

        viewHolder.itemView.saveShipToFavorite.setOnClickListener {
            val bundle = Bundle()
            val savedStation = shipItem(dataSet[position].capacity,dataSet[position].coordinateX,dataSet[position].coordinateY,
                dataSet[position].name,dataSet[position].need,dataSet[position].stock)

            bundle.putSerializable("station",savedStation)
            val navigationController = Navigation.findNavController(viewHolder.itemView)
            navigationController.navigate(R.id.action_stationFragment_to_favoriteFragment,bundle)
           // Log.e("Brk:StationAdapter",savedStation.name)
        }
    }
    override fun getItemCount() = dataSet.size
}
