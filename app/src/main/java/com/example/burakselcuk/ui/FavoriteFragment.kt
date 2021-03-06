package com.example.burakselcuk.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.burakselcuk.R
import com.example.burakselcuk.adapter.FavoriteAdapter
import com.example.burakselcuk.model.shipItem
import com.example.burakselcuk.viewModel.FavoriteFragmentViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.android.synthetic.main.room_item.*


class FavoriteFragment : Fragment() {

    private lateinit var viewModel: FavoriteFragmentViewModel
    private lateinit var singleStationData: shipItem
    private lateinit var adapter:FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(FavoriteFragmentViewModel::class.java)

        val args = this.arguments

        //Get bundle value
        if (args?.get("station")!=null){
            if (requireArguments().getSerializable("station") != null) {
                singleStationData = requireArguments().getSerializable("station")!! as shipItem

                val saveStation = shipItem(singleStationData!!.capacity,
                singleStationData.coordinateX,
                singleStationData.coordinateY,
                singleStationData.name,
                singleStationData.need,
                singleStationData.stock)

                viewModel.addStation(saveStation)
            }else {
                Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()
            }
        }
        //Read all data
        viewModel.readAllData.observe(this, Observer {
            favoriteRecyclerview.layoutManager = LinearLayoutManager(context)
            adapter = FavoriteAdapter(it as ArrayList<shipItem>)
            favoriteRecyclerview.adapter = adapter
        })
    }
}