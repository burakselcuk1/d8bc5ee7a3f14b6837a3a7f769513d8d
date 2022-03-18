package com.example.burakselcuk.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.burakselcuk.R
import com.example.burakselcuk.model.shipItem
import com.example.burakselcuk.viewModel.FavoriteFragmentViewModel
import kotlinx.android.synthetic.main.room_item.view.*


class FavoriteAdapter(private val dataSet: ArrayList<shipItem>) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.roomStationName)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.room_item, viewGroup, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].name
        viewHolder.itemView.starForDelete.setOnClickListener {
            val bundle = Bundle()

            val savedStationforDelete = shipItem(dataSet[position].capacity,dataSet[position].coordinateX,dataSet[position].coordinateY,
                dataSet[position].name,dataSet[position].need,dataSet[position].stock)
                bundle.putSerializable("stationForDelete",savedStationforDelete)

            val navigationController = Navigation.findNavController(viewHolder.itemView)
            navigationController.navigate(R.id.action_favoriteFragment_to_savedStationFragment,bundle)

        }
    }
    override fun getItemCount() = dataSet.size
}
