package com.reactivestudio.navigationcontroller.ui.samplelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.reactivestudio.navigationcontroller.R
import com.reactivestudio.navigationcontroller.data.SampleData
import com.reactivestudio.navigationcontroller.databinding.FragmentSampleListBinding

class SampleListFragment: Fragment(), SampleListItemClickListener {

     /**
      * Sample list fragment data binding.
      */
     private lateinit var viewDataBinding: FragmentSampleListBinding

     /**
      * Recycler view adapter.
      */
     private val adapter = SampleListAdapter()

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
          val view = inflater.inflate(R.layout.fragment_sample_list, container, false)
          viewDataBinding = FragmentSampleListBinding.bind(view)
          viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

          return viewDataBinding.root
     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          adapter.setListener(this)

          val recyclerView = viewDataBinding.sampleDataRecyclerView
          recyclerView.layoutManager = LinearLayoutManager(requireContext())
          recyclerView.adapter = adapter
     }

     override fun onActivityCreated(savedInstanceState: Bundle?) {
          super.onActivityCreated(savedInstanceState)
          val data = mutableListOf<SampleData>()

          // Add some random data just for an example.
          for (i in 1..6) {
               data.add(SampleData(i, "My heading $i", "This my sample item data body $i"))
          }

          adapter.setData(data)
     }

     override fun onSampleItemPressed(sampleData: SampleData) {
          val actionDetail = SampleListFragmentDirections.actionSampleDetails(sampleData)
          findNavController().navigate(actionDetail)
     }
}