package com.jmyebenes.curriculum.ui.work.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.databinding.RowProjectSimpleItemBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel

class ProjectSimpleViewHolder private constructor(val binding: RowProjectSimpleItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: ProjectModel
    private lateinit var onProjectClick: ((ProjectModel) -> Unit)

    fun bind(item: ProjectModel, onProjectClick: ((ProjectModel) -> Unit)) {
        this.item = item
        this.onProjectClick = onProjectClick
        setData()
        setListeners()
    }

    private fun setData() {
        binding.tvName.text = item.name
    }

    private fun setListeners() {
        binding.root.setOnClickListener {
            onProjectClick.invoke(item)
        }
    }

    companion object {
        fun from(parent: ViewGroup): ProjectSimpleViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                RowProjectSimpleItemBinding.inflate(layoutInflater, parent, false)
            return ProjectSimpleViewHolder(binding)
        }
    }
}