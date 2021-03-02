package com.bridou_n.beaconscanner.features.coupons

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bridou_n.beaconscanner.models.CouponResponse
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.coupon_list_item.*

class CouponViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

    val BASE_URL = "https://api.aristan.xyz"

    fun onBind(coupon: CouponResponse, onCouponClick: CouponListAdapter.OnCouponClick) {
        val imageUrl = BASE_URL + coupon.image
        Glide.with(view).load(imageUrl).into(couponImage)

        couponItemName.text = coupon.name
        couponItemPrice.text = "Price: ${coupon.price}"
        couponItemQuantity.text = "Quantity: ${coupon.quantity}"

        itemView.setOnClickListener { onCouponClick.couponQR(imageUrl) }
    }

    override val containerView: View
        get() = view
}