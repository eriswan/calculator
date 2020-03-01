package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.model.SubModel
import com.example.calculator.service.SubService
import kotlinx.android.synthetic.main.fragment_sub.*
import kotlinx.android.synthetic.main.fragment_sub.loading
import kotlinx.android.synthetic.main.fragment_sub.number_a
import kotlinx.android.synthetic.main.fragment_sub.number_b
import kotlinx.android.synthetic.main.fragment_sub.result

class SubFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sub.setOnClickListener {
            callSub()
        }
    }

    private fun callSub() {
        loading.visibility = View.VISIBLE
        result.visibility = View.GONE
        btn_sub.isEnabled = false

        SubService(
            successCallback = ::onSuccess,
            failureCallback = ::onFailure
        ).sub(number_a.text.toString(), number_b.text.toString())
    }

    private fun onFailure(error: Throwable) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_sub.isEnabled = true

        result.text = error.message
    }

    private fun onSuccess(subModel: SubModel) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_sub.isEnabled = true

        result.text = subModel.resultNumber.toString()
    }
}