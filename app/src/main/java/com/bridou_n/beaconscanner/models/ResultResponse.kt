package com.bridou_n.beaconscanner.models

import com.google.gson.annotations.SerializedName

data class ResultResponse(
        @SerializedName("id") var id: Int,
        @SerializedName("name") var name: String,
        @SerializedName("image") var image: String? = null,
        @SerializedName("price") var price: Double,
        @SerializedName("quantity") var quantity: Int,
        @SerializedName("section") var section: String,
        @SerializedName("discount") var discount: String,
        // Format HH:mm:ss
        @SerializedName("discountTimeStart") var discountTimeStart: String,
        @SerializedName("discountTimeEnd") var discountTimeEnd: String,
        @SerializedName("monday") var monday: Boolean,
        @SerializedName("tuesday") var tuesday: Boolean,
        @SerializedName("wednesday") var wednesday: Boolean,
        @SerializedName("thursday") var thursday: Boolean,
        @SerializedName("friday") var friday: Boolean,
        @SerializedName("saturday") var saturday: Boolean,
        @SerializedName("sunday") var sunday: Boolean,
        @SerializedName("repeat_discount") var repeat_discount: Boolean
)
