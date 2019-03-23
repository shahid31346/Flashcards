package com.saishaddai.bwq.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("title") var title: String, @SerializedName("content") var content: String, @SerializedName(
        "image_url"
    ) var imageUrl: String, @SerializedName("deck") var deck: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(imageUrl)
        parcel.writeString(deck)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Card> {
        override fun createFromParcel(parcel: Parcel): Card {
            return Card(parcel)
        }

        override fun newArray(size: Int): Array<Card?> {
            return arrayOfNulls(size)
        }
    }
}
