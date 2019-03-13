package com.saishaddai.bwq.model

import android.os.Parcel
import android.os.Parcelable

class ViewModel {

    class Card(var type: String, var title: String, var content: String) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(type)
            parcel.writeString(title)
            parcel.writeString(content)
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

}