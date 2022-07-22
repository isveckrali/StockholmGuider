package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.model.TouristDestinationsModel
import com.example.myapplication.utils.Constants
import kotlinx.android.synthetic.main.activity_city_detail.*

class CityDetailActivity : AppCompatActivity() {

    // get passed data into this variable
    private lateinit var cityModel:TouristDestinationsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)
        init()
    }

    private fun init(){
        cityModel = intent.extras?.get(Constants.CITY_DETAIL) as TouristDestinationsModel

        shapeableImageView.setImageResource(cityModel.image)
        textview_city_name.text = cityModel.name
        textView_city_details.text = cityModel.description
    }
}