package com.example.myapplication.utils
import com.example.myapplication.R
import com.example.myapplication.model.TouristDestinationsModel

object Constants {

    // Firebase Constants
    // This  is used for the collection name for USERS.
    const val USERS: String = "users"

    // Firebase database field names
    const val DOCUMENT_ID: String = "documentId"


    const val COMETOSTOCKHOLM_PREFERENCES: String = "ComeToStockholmPrefs"

    //City detail object name
    const val CITY_DETAIL: String = "city_detail"

    //Dummy Data
    val cityArrayList = ArrayList<TouristDestinationsModel>()//Creating an empty arraylist
    val touristAttractionsArrayList = ArrayList<TouristDestinationsModel>()

    fun populateCityInfo(){
        cityArrayList.add(TouristDestinationsModel("gamla stan", R.drawable.abbathemuseum,"södra", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too."))//Adding object in arraylist
        cityArrayList.add(TouristDestinationsModel("stockholm",R.drawable.cityhall,"södra", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too2."))//Adding object in arraylist
        cityArrayList.add(TouristDestinationsModel("museum",R.drawable.drottningholm,"sjö", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too3."))//Adding object in arraylist
        cityArrayList.add(TouristDestinationsModel("royal",R.drawable.fotografiska,"ella park", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too4."))//Adding object in arraylist
        cityArrayList.add(TouristDestinationsModel("lund",R.drawable.gamlastan,"erikslund", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too5."))//Adding object in arraylist

    }

    fun populateTouristAttractions(){
        touristAttractionsArrayList.add(TouristDestinationsModel("cafe",R.drawable.gronalund,"nacka", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too6."))//Adding object in arraylist
        touristAttractionsArrayList.add(TouristDestinationsModel("restaurant",R.drawable.modernamuseum,"tekniska hög skolan", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too7."))//Adding object in arraylist
        touristAttractionsArrayList.add(TouristDestinationsModel("park",R.drawable.skansen,"täby", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too8."))//Adding object in arraylist
        touristAttractionsArrayList.add(TouristDestinationsModel("enjoy",R.drawable.theroyalpalace,"norsberg", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too9."))//Adding object in arraylist
        touristAttractionsArrayList.add(TouristDestinationsModel("night life",R.drawable.vasamuseum,"t central", "here is the most enjoyable place in Stockholm. People are gathering here and they try to meet a new person. That is a Swedish mindset and their funny culture. Not just Swedish, but also Scandinavians too10."))//Adding object in arraylist
    }



}