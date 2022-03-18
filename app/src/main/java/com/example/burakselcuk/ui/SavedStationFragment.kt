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
import androidx.navigation.Navigation
import com.example.burakselcuk.R
import com.example.burakselcuk.model.shipItem
import com.example.burakselcuk.viewModel.SavedStationViewModel
import kotlinx.android.synthetic.main.fragment_saved_station.*


class SavedStationFragment : Fragment() {
    private lateinit var singleStationDataForDelete: shipItem
    private lateinit var viewModel: SavedStationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_station, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SavedStationViewModel::class.java)
        val argsTwo = this.arguments

        if (argsTwo?.get("stationForDelete")!=null){
            if (requireArguments().getSerializable("stationForDelete") != null) {
                singleStationDataForDelete = requireArguments().getSerializable("stationForDelete")!! as shipItem

                val deleteStation = shipItem(singleStationDataForDelete!!.capacity,
                    singleStationDataForDelete.coordinateX,
                    singleStationDataForDelete.coordinateY,
                    singleStationDataForDelete.name,
                    singleStationDataForDelete.need,
                    singleStationDataForDelete.stock)

                savedStationName.text = deleteStation.name

                deleteStationFromRoom.setOnClickListener {

                    val builder = AlertDialog.Builder(requireContext())
                    builder.setPositiveButton("Yes"){_, _ ->
                        viewModel.deleteStation(deleteStation)
                        val navigationController = Navigation.findNavController(it)
                        navigationController.navigate(R.id.action_savedStationFragment_to_favoriteFragment)
                        Toast.makeText(requireContext(),"Station deleted!", Toast.LENGTH_SHORT).show()


                    }
                    builder.setNegativeButton("No"){_, _ ->}
                    builder.setTitle("Delete ${deleteStation.name}")
                    builder.setMessage("Are you sure delete this station ${deleteStation.name} ?")
                    builder.create().show()



                }

            }else {
                Toast.makeText(requireContext(),"error", Toast.LENGTH_SHORT).show()
            }
        }

    }
    }

