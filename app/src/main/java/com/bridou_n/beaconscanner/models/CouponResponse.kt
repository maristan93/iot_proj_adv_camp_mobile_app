package com.bridou_n.beaconscanner.models

import com.google.gson.annotations.SerializedName

data class CouponResponse(
        @SerializedName("id") var id: Int,
        @SerializedName("name") var name: String,
        @SerializedName("image") var image: String,
        @SerializedName("price") var price: Double,
        @SerializedName("quantity") var quantity: Int
)

//"id": 7,
//"name": "Fanta",
//"image": "/media/product/image/Fanta_23iBGR5.jpg",
//"price": "9.60",
//"quantity": "1"
