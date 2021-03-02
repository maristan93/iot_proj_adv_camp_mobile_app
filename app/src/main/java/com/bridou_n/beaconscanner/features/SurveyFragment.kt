package com.bridou_n.beaconscanner.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bridou_n.beaconscanner.API.DataService
import com.bridou_n.beaconscanner.R
import com.bridou_n.beaconscanner.models.SurveyRequest
import com.bridou_n.beaconscanner.utils.extensionFunctions.component
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_survey.*
import javax.inject.Inject


class SurveyFragment : DialogFragment() {

    @Inject
    lateinit var dataService: DataService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle)
        component().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_survey, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit.setOnClickListener {
            if (service.rating == 0f) Toast.makeText(requireContext(), "Service rating is required", Toast.LENGTH_SHORT).show().also { return@setOnClickListener }
            if (comment.text.isNullOrBlank()) Toast.makeText(requireContext(), "Comment field is required", Toast.LENGTH_SHORT).show().also { return@setOnClickListener }

            val request = SurveyRequest(service.rating.toInt(), comment.text.toString())

            dataService.sendSurveyResults(request)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { }
                    .subscribe({
                        Toast.makeText(requireContext(), "Sent!", Toast.LENGTH_SHORT).show()
                        dismiss()
                    }, {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    })
        }
    }

    companion object {

        const val TAG = "SurveyFragment"

        @JvmStatic
        fun newInstance() =
                SurveyFragment()
    }
}