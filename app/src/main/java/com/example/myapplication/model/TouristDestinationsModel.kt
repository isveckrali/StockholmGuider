package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class TouristDestinationsModel(
    val name: String = "",
    val image: Int = 0,
    val streetName: String = "",
    val description: String= ""
) : Parcelable, Serializable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readInt()!!,
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeInt(image)
        writeString(streetName)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TouristDestinationsModel> = object : Parcelable.Creator<TouristDestinationsModel> {
            override fun createFromParcel(source: Parcel): TouristDestinationsModel = TouristDestinationsModel(source)
            override fun newArray(size: Int): Array<TouristDestinationsModel?> = arrayOfNulls(size)
        }
    }
}