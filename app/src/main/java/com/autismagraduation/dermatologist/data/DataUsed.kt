package com.autismagraduation.dermatologist.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataUsed(
    val img: Int,
    val AdviseTitle: String,
    val AdviseDiscription: String,
    val AdviseUse: String
): Parcelable
