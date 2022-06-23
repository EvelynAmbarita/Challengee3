package com.binar.challenge3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Person(
    val name: String,
    val age: Int?=null,
    val Profession: String?=null,
    val Salary: String?=null,
    val Status: String?=null,
    val gender: String?=null,
    val result: String?=null
): Parcelable
