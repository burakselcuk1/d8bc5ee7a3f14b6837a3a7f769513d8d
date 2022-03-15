package com.example.burakselcuk.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.burakselcuk.R
import com.example.burakselcuk.adapter.StationAdapter
import com.example.burakselcuk.viewModel.StationFragmentViewModel
import kotlinx.android.synthetic.main.fragment_station.*


class StationFragment : Fragment() {

    private lateinit var viewModel: StationFragmentViewModel
    private lateinit var adapter: StationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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

    }

}