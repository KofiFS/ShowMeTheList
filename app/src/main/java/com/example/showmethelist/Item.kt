package com.example.showmethelist

import android.os.Parcel
import android.os.Parcelable

// Data class representing an item in the list
data class Item(
    val id: Int,            // Unique identifier for the item
    val title: String,      // Title of the item
    val subtitle: String,   // Subtitle of the item
    val description: String, // Description of the item
    val imageResId: Int     // Resource ID for the item's image
) : Parcelable {

    // Parcelable constructor to recreate the object from a Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    // Write object data to Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(subtitle)
        parcel.writeString(description)
        parcel.writeInt(imageResId)
    }

    // Describe the kinds of special objects contained in this Parcelable instance
    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Item> {
        // Create a new instance of the Parcelable class, instantiating it from the given Parcel
        override fun createFromParcel(parcel: Parcel): Item = Item(parcel)

        // Create a new array of the Parcelable class with the specified size
        override fun newArray(size: Int): Array<Item?> = arrayOfNulls(size)
    }
}
