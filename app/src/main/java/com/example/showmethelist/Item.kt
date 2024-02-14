package com.example.showmethelist

import android.os.Parcel
import android.os.Parcelable

// Updated data class representing an item
data class Item(
    val id: Int,
    val title: String,
    val subtitle: String,
    val description: String, // New field
    val imageResId: Int
) : Parcelable {
    // Updated Parcelable constructor
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "", // Handle description
        parcel.readInt()
    )

    // Updated write to parcel to include id and description
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(subtitle)
        parcel.writeString(description) // Write description to parcel
        parcel.writeInt(imageResId)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item = Item(parcel)

        override fun newArray(size: Int): Array<Item?> = arrayOfNulls(size)
    }
}