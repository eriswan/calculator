package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.calculator.model.MultModel
import com.example.calculator.service.MultService
import kotlinx.android.synthetic.main.fragment_mult.*
import kotlinx.android.synthetic.main.fragment_sum.loading
import kotlinx.android.synthetic.main.fragment_sum.number_a
import kotlinx.android.synthetic.main.fragment_sum.number_b
import kotlinx.android.synthetic.main.fragment_sum.result

class MultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mult, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_mult.setOnClickListener {
            callMult()
        }
    }

    private fun callMult() {
        loading.visibility = View.VISIBLE
        result.visibility = View.GONE
        btn_mult.isEnabled = false

        MultService(
            successCallback = ::onSuccess,
            failureCallback = ::onFailure
        ).mult(number_a.text.toString(), number_b.text.toString())
    }

    private fun onFailure(error: Throwable) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_mult.isEnabled = true

        result.text = error.message
    }

    private fun onSuccess(multModel: MultModel) {
        loading.visibility = View.GONE
        result.visibility = View.VISIBLE
        btn_mult.isEnabled = true

        result.text = multModel.resultNumber.toString()
    }
}