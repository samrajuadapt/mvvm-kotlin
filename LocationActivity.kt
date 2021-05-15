package com.samboy.map.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.samboy.map.R
import com.samboy.map.databinding.ActivityMapBinding
import com.samboy.map.map.adapter.LocationAdapter
import com.samboy.map.map.repository.MapRepository
import com.samboy.map.map.viewmodel.MapFactory
import com.samboy.map.map.viewmodel.MapViewModel
import com.samboy.map.utils.addMarker
import com.samboy.map.utils.loge
import kotlinx.android.synthetic.main.activity_loation.*

class LocationActivity : AppCompatActivity() {
    private lateinit var mapViewModel:MapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loation)
        initViewModel()
        observe()
        mapViewModel.fetchLocations()
    }

    private fun initViewModel(){
        val repository = MapRepository();
        val mapFactory = MapFactory(repository);
        mapViewModel = ViewModelProvider(this,mapFactory).get(MapViewModel::class.java)

    }
    private fun observe(){
        mapViewModel.mLocations.observe(this, Observer { mList->
            loge(Gson().toJson(mList))
            rvLocation.also {
                it.layoutManager = LinearLayoutManager(this)
                it.adapter = LocationAdapter(mList)
            }
        })
    }
}