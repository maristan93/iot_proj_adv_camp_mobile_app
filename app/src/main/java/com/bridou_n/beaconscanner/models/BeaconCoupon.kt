package com.bridou_n.beaconscanner.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.bridou_n.beaconscanner.Database.BeaconsDao
import com.google.gson.annotations.SerializedName

@Entity(
        tableName = BeaconsDao.TABLE_NAME_COUPON,
        primaryKeys = [
            "id"
        ]
)
data class BeaconCoupon(
        @SerializedName("id")
        @ColumnInfo(name = "id") var id: Int,
        @SerializedName("name")
        @ColumnInfo(name = "name") var name: String,
        @SerializedName("image")
        @ColumnInfo(name = "image") var image: String,
        @SerializedName("price")
        @ColumnInfo(name = "price") var price: Double,
        @SerializedName("quantity")
        @ColumnInfo(name = "quantity") var quantity: Int,
        @SerializedName("section")
        @ColumnInfo(name = "section") var section: String,
        @SerializedName("discount")
        @ColumnInfo(name = "discount") var discount: String,
        // Format HH:mm:ss
        @SerializedName("discountTimeStart")
        @ColumnInfo(name = "discountTimeStart") var discountTimeStart: String,
        @SerializedName("discountTimeEnd")
        @ColumnInfo(name = "discountTimeEnd") var discountTimeEnd: String,
        @SerializedName("monday")
        @ColumnInfo(name = "monday") var monday: Boolean,
        @SerializedName("tuesday")
        @ColumnInfo(name = "tuesday") var tuesday: Boolean,
        @SerializedName("wednesday")
        @ColumnInfo(name = "wednesday") var wednesday: Boolean,
        @SerializedName("thursday")
        @ColumnInfo(name = "thursday") var thursday: Boolean,
        @SerializedName("friday")
        @ColumnInfo(name = "friday") var friday: Boolean,
        @SerializedName("saturday")
        @ColumnInfo(name = "saturday") var saturday: Boolean,
        @SerializedName("sunday")
        @ColumnInfo(name = "sunday") var sunday: Boolean,
        @SerializedName("repeat_discount")
        @ColumnInfo(name = "repeat_discount") var repeat_discount: Boolean
) {
    companion object {
        fun createFromResponse(response: ResultResponse): BeaconCoupon {
            return BeaconCoupon(
                    response.id,
                    response.name,
                    response.image ?: "",
                    response.price,
                    response.quantity,
                    response.section,
                    response.discount,
                    response.discountTimeStart,
                    response.discountTimeEnd,
                    response.monday,
                    response.tuesday,
                    response.wednesday,
                    response.thursday,
                    response.friday,
                    response.saturday,
                    response.sunday,
                    response.repeat_discount
            )
        }
    }
}

