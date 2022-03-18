package com.example.burakselcuk.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.burakselcuk.R
import com.example.burakselcuk.Util.Helper
import com.example.burakselcuk.adapter.SearchAdapter
import com.example.burakselcuk.model.shipItem
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_station.*


class SearchFragment : Fragment() {

    private lateinit var searchAdapter:SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //For search
        sample_recyclerView.layoutManager = LinearLayoutManager(context)
        searchAdapter = SearchAdapter(requireContext(), Helper.getVersionsList())
        sample_recyclerView.adapter = searchAdapter

        sample_editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
                sample_recyclerView.visibility = View.VISIBLE
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                sample_recyclerView.visibility = View.VISIBLE

            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }
    //for search
    fun filter(text: String) {

        val filteredCourseAry: ArrayList<shipItem> = ArrayList()

        val courseAry : ArrayList<shipItem> = Helper.Companion.getVersionsList()

        for (eachCourse in courseAry) {
            if (eachCourse.name!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.name!!.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(eachCourse)

                sample_recyclerView.visibility= View.VISIBLE
            }
        }
        //calling a method of the adapter class and passing the filtered list
        searchAdapter.filterList(filteredCourseAry);
    }
}