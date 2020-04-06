package com.rplgdc.covidapp.base.data.model

import com.google.gson.annotations.SerializedName

data class Sumary(
    @SerializedName("Global") val global: Global,
    @SerializedName("Countries") val countries: List<Country>,
    @SerializedName("Date") val date: String
)