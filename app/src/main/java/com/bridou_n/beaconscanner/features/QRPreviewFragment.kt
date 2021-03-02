package com.bridou_n.beaconscanner.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bridou_n.beaconscanner.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_q_r_preview.*

class QRPreviewFragment : DialogFragment() {

    private lateinit var image: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_q_r_preview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).load(image).into(qrPreview)

        close.setOnClickListener {
            this.dismiss()
        }
    }

    companion object {

        const val TAG = "QRPreviewFragment"

        @JvmStatic
        fun newInstance(image: String) =
                QRPreviewFragment().apply {
                    this.image = image
                }
    }
}