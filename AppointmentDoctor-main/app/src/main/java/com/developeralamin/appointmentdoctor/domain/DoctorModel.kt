package com.developeralamin.appointmentdoctor.domain

import android.os.Parcel
import android.os.Parcelable

data class DoctorModel(
    val Address: String = "",
    val Biography: String = "",
    val Expriense: Int = 0,
    val Id: Int = 0,
    val Location: String = "",
    val Mobile: String = "",
    val Name: String = "",
    val Patiens: String = "",
    val Picture: String = "",
    val Rating: Double = 0.0,
    val Site: String = "",
    val Special: String = ""
) : Parcelable {
    constructor() : this(
        "", "", 0, 0, "", "", "", "", "", 0.0, "", ""
    )

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeInt(Expriense)
        parcel.writeInt(Id)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(Name)
        parcel.writeString(Patiens)
        parcel.writeString(Picture)
        parcel.writeDouble(Rating)
        parcel.writeString(Site)
        parcel.writeString(Special)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctorModel> {
        override fun createFromParcel(parcel: Parcel): DoctorModel {
            return DoctorModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctorModel?> {
            return arrayOfNulls(size)
        }
    }
}
