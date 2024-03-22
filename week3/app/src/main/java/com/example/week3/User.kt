package com.example.week3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val userName:String,
    val gender:Boolean
) : Parcelable