package com.example.burakselcuk.ui

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.burakselcuk.R
import com.example.burakselcuk.adapter.StationAdapter
import com.example.burakselcuk.model.spaceShip
import com.example.burakselcuk.viewModel.StationFragmentViewModel
import kotlinx.android.synthetic.main.fragment_station.*


class StationFragment : Fragment() {

    private lateinit var viewModel: StationFragmentViewModel
    private lateinit var adapter: StationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_station, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(requireActivity()).get(StationFragmentViewModel::class.java)

        viewModel._shipes.observe(this, Observer {
            adapter = StationAdapter(it)
            shipRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            shipRecyclerView.adapter = adapter
        })

        searchButton.setOnClickListener {
            val navigationController = Navigation.findNavController(it)
            navigationController.navigate(R.id.action_stationFragment_to_searchFragment)
        }

        swipeResflesh.setOnRefreshListener {
            refleshData()
        }
}

    private fun refleshData() {
        shipRecyclerView.visibility = View.GONE
        viewModel._shipes.observe(this, Observer {
            adapter = StationAdapter(it)
            shipRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            shipRecyclerView.adapter = adapter
        })
        shipRecyclerView.visibility = View.VISIBLE
        swipeResflesh.isRefreshing = false
    }
}