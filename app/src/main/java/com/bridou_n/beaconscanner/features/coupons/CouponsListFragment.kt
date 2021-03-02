package com.bridou_n.beaconscanner.features.coupons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bridou_n.beaconscanner.R
import com.bridou_n.beaconscanner.features.QRPreviewFragment
import com.bridou_n.beaconscanner.models.CouponResponse
import kotlinx.android.synthetic.main.fragment_coupons_list.*

class CouponsListFragment : DialogFragment(), CouponListAdapter.OnCouponClick {

    private lateinit var coupons: List<CouponResponse>
    private val adapter = CouponListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_coupons_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close.setOnClickListener {
            this.dismiss()
        }

        adapter.setItems(coupons)

        couponList.layoutManager = LinearLayoutManager(requireContext())
        couponList.adapter = adapter
    }

    companion object {

        const val TAG = "CouponsListFragment"

        @JvmStatic
        fun newInstance(list: List<CouponResponse>) = CouponsListFragment().apply {
            this.coupons = list
        }
    }

    override fun couponQR(image: String) {
        QRPreviewFragment.newInstance(image).show(childFragmentManager, QRPreviewFragment.TAG)
    }
}