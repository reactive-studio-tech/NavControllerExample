package com.reactivestudio.navigationcontroller.ui.samplelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.navigationcontroller.data.SampleData
import com.reactivestudio.navigationcontroller.databinding.ViewHolderSampleListItemBinding

class SampleListAdapter: RecyclerView.Adapter<SampleListItemViewHolder>() {

    /**
     * Data source list.
     */
    private val dataSource = mutableListOf<SampleData>()

    /**
     * Item click listener.
     */
    private var itemClickListener: SampleListItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderSampleListItemBinding.inflate(inflater, parent, false)
        return SampleListItemViewHolder(binding, itemClickListener)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: SampleListItemViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    /**
     * Sets the list item click listener.
     */
    fun setListener(listener: SampleListItemClickListener) {
        itemClickListener = listener
    }

    /**
     * Sets the data to display in recycler view.
     */
    fun setData(list: List<SampleData>) {
        dataSource.clear()
        dataSource.addAll(list)
        notifyDataSetChanged()
    }
}