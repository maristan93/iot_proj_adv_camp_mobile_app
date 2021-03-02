package com.bridou_n.beaconscanner.features.couponsGenerateList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bridou_n.beaconscanner.R
import com.bridou_n.beaconscanner.models.ResultResponse
import kotlinx.android.synthetic.main.fragment_coupons_list.close
import kotlinx.android.synthetic.main.fragment_coupons_list.couponList
import kotlinx.android.synthetic.main.fragment_generate_coupons_list.*

class CouponsGenerateListFragment(private var actionListener: OnActionSelect, private var onSelect: (ResultResponse) -> Unit) : DialogFragment(), CouponGenerateListAdapter.OnClickListener {

    private lateinit var coupons: List<ResultResponse>
    private val adapter = CouponGenerateListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_generate_coupons_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close.setOnClickListener {
            this.dismiss()
        }

        adapter.setItems(coupons)

        if (coupons.isEmpty()) emptyState.visibility = View.VISIBLE

        couponList.layoutManager = LinearLayoutManager(requireContext())
        couponList.adapter = adapter

        checkout.setOnClickListener {
            actionListener.checkout(this)
        }

        addAnother.setOnClickListener {
            actionListener.addAnother(this)
        }
    }

    companion object {

        const val TAG = "CouponsGenerateListFragment"

        @JvmStatic
        fun newInstance(list: List<ResultResponse>, onActionSelect: OnActionSelect, onSelect: (ResultResponse) -> Unit) = CouponsGenerateListFragment(onActionSelect, onSelect).apply {
            this.coupons = list
        }
    }

    override fun onSelect(result: ResultResponse) {
        this.onSelect.invoke(result)
    }

    interface OnActionSelect {
        fun checkout(dialog: DialogFragment)
        fun addAnother(dialog: DialogFragment)
    }
}