package com.bridou_n.beaconscanner.features.coupons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bridou_n.beaconscanner.models.CouponResponse
import com.bridou_n.beaconscanner.R

class CouponListAdapter(var listener: OnCouponClick) : RecyclerView.Adapter<CouponViewHolder>() {

    private var items: List<CouponResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponViewHolder {
        val from = LayoutInflater.from(parent.context).inflate(R.layout.coupon_list_item, parent, false)
        return CouponViewHolder(from)
    }

    override fun onBindViewHolder(holder: CouponViewHolder, position: Int) {
        holder.onBind(items[position], listener)
    }

    override fun getItemCount() = items.size

    fun setItems(coupons: List<CouponResponse>) {
        this.items = coupons
        notifyDataSetChanged()
    }

    interface OnCouponClick {
        fun couponQR(image: String)
    }
}