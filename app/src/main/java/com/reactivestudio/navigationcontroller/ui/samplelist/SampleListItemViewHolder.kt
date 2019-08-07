package com.reactivestudio.navigationcontroller.ui.samplelist

import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.navigationcontroller.data.SampleData
import com.reactivestudio.navigationcontroller.databinding.ViewHolderSampleListItemBinding

class SampleListItemViewHolder(private val binding: ViewHolderSampleListItemBinding, private val listener: SampleListItemClickListener?): RecyclerView.ViewHolder(binding.root) {

    fun bind(data: SampleData) {
        binding.sampleData = data
        listener?.let {
            binding.listener = it
        }

        binding.executePendingBindings()
    }
}