package com.example.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import com.example.calculator.model.AboutModel
import com.example.calculator.service.AboutService
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.loading

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loading.visibility = View.VISIBLE
        about.visibility = View.GONE
        version.visibility = View.GONE
        error_message.visibility = View.GONE

        AboutService(
            successCallback = ::onSuccess,
            failureCallback = ::onFailure
        ).about()
    }

    private fun onFailure(error: Throwable) {
        loading.visibility = View.GONE
        about.visibility = View.GONE
        version.visibility = View.GONE
        error_message.visibility = View.VISIBLE
        error_message.text = error.message
    }

    private fun onSuccess(aboutModel: AboutModel) {
        loading.visibility = View.GONE
        about.visibility = View.VISIBLE
        version.visibility = View.VISIBLE
        error_message.visibility = View.GONE
        about.text = aboutModel.about
        version.text = aboutModel.version
    }
}

