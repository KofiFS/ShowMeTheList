package com.example.showmethelist

import android.os.Parcel
import android.os.Parcelable

// Data class representing an item
data class Item(val title: String, val subtitle: String, val imageResId: Int) : Parcelable {
    // Parcelable constructor
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    // Write data to parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(subtitle)
        parcel.writeInt(imageResId)
    }

    // Describe contents, always return 0
    override fun describeContents(): Int {
        return 0
    }

    // Creator object to create instances of the Parcelable class from a parcel
    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        // Create a new array of the Parcelable class
        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}
