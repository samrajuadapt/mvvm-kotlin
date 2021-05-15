package com.samboy.map.map.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.samboy.map.R
import com.samboy.map.databinding.AdaLocationBinding
import com.samboy.map.models.Location

/**
 * Created by Sam Raju on 5/9/21.
 */
class LocationAdapter(private val mList:List<Location>): RecyclerView.Adapter<LocationAdapter.LocationHolder>(){

    override fun getItemCount() = mList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    LocationHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),R.layout.ada_location,parent,false
    ))

    override fun onBindViewHolder(holder: LocationHolder, position: Int) {
        holder.binding.location = mList[position]
    }


    inner class LocationHolder(val binding:AdaLocationBinding):RecyclerView.ViewHolder(binding.root)


}