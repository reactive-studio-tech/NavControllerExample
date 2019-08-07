package com.reactivestudio.navigationcontroller.ui.sampledetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reactivestudio.navigationcontroller.R
import com.reactivestudio.navigationcontroller.databinding.FragmentSampleDetailsBinding

class SampleDetailsFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentSampleDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sample_details, container, false)
        viewDataBinding = FragmentSampleDetailsBinding.bind(view)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val safeArgs = SampleDetailsFragmentArgs.fromBundle(it)
            viewDataBinding.sampleData = safeArgs.sampleData
            viewDataBinding.executePendingBindings()
        }
    }
}