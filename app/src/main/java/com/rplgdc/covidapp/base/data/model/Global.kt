package com.rplgdc.covidapp.base.data.model

import com.google.gson.annotations.SerializedName

data class Global(
    @SerializedName("NewConfirmed")
    var newConfirmed: Int?,
    @SerializedName("NewDeaths")
    val newDeaths: Int,
    @SerializedName("NewRecovered")
    val newRecovered: Int,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int
)