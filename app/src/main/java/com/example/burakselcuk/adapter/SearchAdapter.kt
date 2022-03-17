package com.example.burakselcuk.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.burakselcuk.R
import com.example.burakselcuk.model.shipItem


class SearchAdapter(val context : Context, var courseList: ArrayList<shipItem>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.txtTitle?.text = courseList[p1].name
        p0?.txtContent?.text = courseList[p1].name
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.search_item_row, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.appOSTitle_txtVw)
        val txtContent = itemView.findViewById<TextView>(R.id.appOSDetails_txtVw)
    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<shipItem>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}