package com.bridou_n.beaconscanner.features.couponsGenerateList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bridou_n.beaconscanner.models.CouponResponse
import com.bridou_n.beaconscanner.R
import com.bridou_n.beaconscanner.models.ResultResponse

class CouponGenerateListAdapter(var listener: OnClickListener) : RecyclerView.Adapter<CouponGenerateViewHolder>() {

    private var items: List<ResultResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponGenerateViewHolder {
        val from = LayoutInflater.from(parent.context).inflate(R.layout.coupon_list_item, parent, false)
        return CouponGenerateViewHolder(from)
    }

    override fun onBindViewHolder(holderGenerate: CouponGenerateViewHolder, position: Int) {
        holderGenerate.onBind(items[position], listener)
    }

    override fun getItemCount() = items.size

    fun setItems(coupons: List<ResultResponse>) {
        this.items = coupons
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onSelect(result: ResultResponse)
    }
}