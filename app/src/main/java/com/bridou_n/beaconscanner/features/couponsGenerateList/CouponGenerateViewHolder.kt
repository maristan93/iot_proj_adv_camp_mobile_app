package com.bridou_n.beaconscanner.features.couponsGenerateList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bridou_n.beaconscanner.models.ResultResponse
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.coupon_list_item.*

class CouponGenerateViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

    val BASE_URL = "https://api.aristan.xyz"

    fun onBind(coupon: ResultResponse, listener: CouponGenerateListAdapter.OnClickListener) {
        Glide.with(view).load(BASE_URL + coupon.image).into(couponImage)

        couponItemName.text = coupon.name
        couponItemPrice.text = "Price: ${coupon.price}"
        couponItemQuantity.text = "Quantity: ${coupon.quantity}"

        itemView.setOnClickListener { listener.onSelect(coupon) }
    }

    override val containerView: View
        get() = view
}