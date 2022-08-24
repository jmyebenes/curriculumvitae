package com.jmyebenes.curriculum.ui.studies.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.domain.model.StudyModel
import java.security.SecureRandom

class StudyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var studyList = listOf<StudyModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StudyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? StudyViewHolder)?.bind(studyList[position])
    }

    override fun getItemCount() = studyList.size

    fun setData(studyList: List<StudyModel>) {
        this.studyList = studyList
        notifyDataSetChanged()
    }
}