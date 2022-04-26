package com.samsdk.myfirstproject.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    val image: Int,
    val jobTitle: String,
    val company: String,
    val location: String,
    val time: String
) : Parcelable
