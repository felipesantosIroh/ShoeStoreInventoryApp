package com.irohouse.shoestoreinventoryapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String,
    var size: Double,
    var company: String,
    var description: String
) : Parcelable