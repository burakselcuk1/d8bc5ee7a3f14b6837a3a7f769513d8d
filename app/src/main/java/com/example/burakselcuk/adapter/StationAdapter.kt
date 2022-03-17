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
            // Define click listener for the ViewHolder's View.
            stationName = view.findViewById(R.id.stationName)
            capacity = view.findViewById(R.id.capacity)
            stationStock = view.findViewById(R.id.stationStock)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.ship_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.stationName.text = dataSet[position].name
        viewHolder.capacity.text = dataSet[position].capacity.toString()
        viewHolder.stationStock.text = dataSet[position].stock.toString()

        viewHolder.itemView.saveShipToFavorite.setOnClickListener {
            val bundle = Bundle()
            val savedStation = shipItem(dataSet[position].capacity,dataSet[position].coordinateX,dataSet[position].coordinateY,
                dataSet[position].name,dataSet[position].need,dataSet[position].stock)

            bundle.putSerializable("station",savedStation)!!
            val navigationController = Navigation.findNavController(viewHolder.itemView)
            navigationController.navigate(R.id.action_stationFragment_to_favoriteFragment,bundle!!)
            Log.e("Brk:StationAdapter",savedStation.name)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
