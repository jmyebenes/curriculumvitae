package com.jmyebenes.curriculum.ui.work.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.databinding.RowProjectItemBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel

class ProjectViewHolder private constructor(val binding: RowProjectItemBinding) :
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
        fun from(parent: ViewGroup): ProjectViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                RowProjectItemBinding.inflate(layoutInflater, parent, false)
            return ProjectViewHolder(binding)
        }
    }
}