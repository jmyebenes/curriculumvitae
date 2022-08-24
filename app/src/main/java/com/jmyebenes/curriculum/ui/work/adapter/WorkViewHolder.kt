package com.jmyebenes.curriculum.ui.work.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.R
import com.jmyebenes.curriculum.core.extensions.gone
import com.jmyebenes.curriculum.core.extensions.loadImage
import com.jmyebenes.curriculum.core.extensions.visible
import com.jmyebenes.curriculum.databinding.RowWorkItemBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel
import com.jmyebenes.curriculum.domain.model.WorkModel

class WorkViewHolder private constructor(val binding: RowWorkItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: WorkModel
    private lateinit var adapter: ProjectAdapter
    private lateinit var onWorkClick: ((WorkModel) -> Unit)
    private lateinit var onProjectClick: ((ProjectModel) -> Unit)
    private var childrenCollapsed = false

    fun bind(
        item: WorkModel,
        onWorkClick: ((WorkModel) -> Unit),
        onProjectClick: ((ProjectModel) -> Unit)
    ) {
        this.item = item
        this.onWorkClick = onWorkClick
        this.onProjectClick = onProjectClick
        setData()
        setListeners()
    }

    private fun setData() {
        binding.ivWorkLogo.loadImage(item.image)
        var date = "${item.initDate} · ${item.endDate}"
        if (item.active) {
            binding.vTopLine.gone()
            binding.ivWorkLogo.borderColor =
                ContextCompat.getColor(binding.root.context, R.color.green_primary_medium)
            date = item.initDate
            binding.tvCurrent.visible()
        }
        binding.tvDate.text = date
        binding.tvName.text = item.name
        binding.tvPosition.text = item.position
        adapter = ProjectAdapter(onProjectClick)
        binding.rvProyectList.adapter = adapter
        adapter.setData(item.projects)
    }

    private fun setListeners() {
        binding.root.setOnClickListener {
            onWorkClick.invoke(item)
        }
    }

    companion object {
        fun from(parent: ViewGroup): WorkViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                RowWorkItemBinding.inflate(layoutInflater, parent, false)
            return WorkViewHolder(binding)
        }
    }
}