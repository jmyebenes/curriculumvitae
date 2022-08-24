package com.jmyebenes.curriculum.ui.work.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.domain.model.ProjectModel
import com.jmyebenes.curriculum.domain.model.WorkModel

class WorkAdapter(
    var onWorkClick: ((WorkModel) -> Unit),
    var onProjectClick: ((ProjectModel) -> Unit)
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var workList = listOf<WorkModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WorkViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? WorkViewHolder)?.bind(workList[position], onWorkClick, onProjectClick)
    }

    override fun getItemCount() = workList.size

    fun setData(workList: List<WorkModel>) {
        this.workList = workList
        notifyDataSetChanged()
    }
}