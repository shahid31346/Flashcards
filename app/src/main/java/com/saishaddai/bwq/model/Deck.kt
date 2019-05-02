package com.saishaddai.bwq.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Deck(
    @SerializedName("name") var name: String,
    @SerializedName("source") var source: String,
    @SerializedName("short") var short: String,
    @SerializedName("cards") var cards: Int,
    @SerializedName("priority") var priority: Int,
    @SerializedName("description") var description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(source)
        parcel.writeString(short)
        parcel.writeInt(priority)
        parcel.writeInt(priority)
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
