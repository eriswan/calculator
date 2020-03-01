package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.model.SumModel
import com.example.calculator.service.SumService
import kotlinx.android.synthetic.main.fragment_sum.*

class SumFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sum.setOnClickListener {
            callSum()
        }
    }

    private fun callSum() {
        loading.visibility = View.VISIBLE
        result.visibility = View.GONE
        btn_sum.isEnabled = false

        SumService(
            successCallback = ::onSuccess,
            failureCallback = ::onFailure
        ).sum(number_a.text.toString(), number_b.text.toString())
    }

    private fun onFailure(error: Throwable) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_sum.isEnabled = true

        result.text = error.message
    }

    private fun onSuccess(sumModel: SumModel) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_sum.isEnabled = true

        result.text = sumModel.resultNumber.toString()
    }
}