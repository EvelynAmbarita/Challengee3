package com.binar.challenge3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Person(
    val name: String,
    val age: Int?,
    val height: Double?,
    val weight: Double?,
    val gender: String?,
): Parcelable
