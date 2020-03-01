package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.model.DivModel
import com.example.calculator.service.DivService
import kotlinx.android.synthetic.main.fragment_div.*
import kotlinx.android.synthetic.main.fragment_sum.loading
import kotlinx.android.synthetic.main.fragment_sum.number_a
import kotlinx.android.synthetic.main.fragment_sum.number_b
import kotlinx.android.synthetic.main.fragment_sum.result

class DivFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_div, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_div.setOnClickListener {
            callDiv()
        }
    }

    private fun callDiv() {
        loading.visibility = View.VISIBLE
        result.visibility = View.GONE
        btn_div.isEnabled = false

        DivService(
            successCallback = ::onSuccess,
            failureCallback = ::onFailure
        ).div(number_a.text.toString(), number_b.text.toString())
    }

    private fun onFailure(error: Throwable) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_div.isEnabled = true

        result.text = error.message
    }

    private fun onSuccess(divModel: DivModel) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_div.isEnabled = true

        result.text = divModel.resultNumber.toString()
    }
}
