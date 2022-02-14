package com.example.android.covidproject.network.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CovidResponse (
    val response: List<Country>?
): Parcelable

@Parcelize
data class Country (
    val continent: String?,
    val country: String?,
    val population: Int?,
    val cases: Cases,
    val deaths: Deaths
): Parcelable

@Parcelize
data class Cases(
    val new: String?,
    val active: Int?,
    val recovered: Int?,
    val total: Int?
): Parcelable

@Parcelize
data class Deaths (
    val total: Int?
): Parcelable
