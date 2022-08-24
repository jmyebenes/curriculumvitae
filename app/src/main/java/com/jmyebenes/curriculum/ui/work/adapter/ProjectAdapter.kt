package com.jmyebenes.curriculum.ui.work.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.domain.model.ProjectModel

class ProjectAdapter(private val onProjectClick: ((ProjectModel) -> Unit)) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var projectList = listOf<ProjectModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProjectViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ProjectViewHolder)?.bind(projectList[position], onProjectClick)
    }

    override fun getItemCount() = projectList.size

    fun setData(proyectList: List<ProjectModel>) {
        this.projectList = proyectList
        notifyDataSetChanged()
    }
}