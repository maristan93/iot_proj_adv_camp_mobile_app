package com.bridou_n.beaconscanner.models

import com.google.gson.annotations.SerializedName

data class SurveyRequest(
        @SerializedName("service") val service: Int,
        @SerializedName("comment") val comment: String
)
