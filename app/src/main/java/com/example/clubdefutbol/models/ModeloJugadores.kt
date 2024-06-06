package com.example.clubdefutbol.models

import android.os.Parcel
import android.os.Parcelable

data class ModeloJugadores(
    val id: String?,
    val nombre: String?,
    val posicion: String?,
    val camiseta: String?,
    val club: String?,
    val foto: String?,
    val historia: String?,
    val valor: String?,
)
    :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeString(posicion)
        parcel.writeString(camiseta)
        parcel.writeString(club)
        parcel.writeString(foto)
        parcel.writeString(historia)
        parcel.writeString(valor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModeloJugadores> {
        override fun createFromParcel(parcel: Parcel): ModeloJugadores {
            return ModeloJugadores(parcel)
        }

        override fun newArray(size: Int): Array<ModeloJugadores?> {
            return arrayOfNulls(size)
        }
    }

}
