package com.ifs21007.whatsuppbrou.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Call(
    val icon: Int,
    val contact : String,
    val isi: String
): Parcelable