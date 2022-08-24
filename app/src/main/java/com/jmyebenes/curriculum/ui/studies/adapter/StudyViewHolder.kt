package com.jmyebenes.curriculum.ui.studies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.databinding.RowStudyItemBinding
import com.jmyebenes.curriculum.domain.model.StudyModel

class StudyViewHolder private constructor(val binding: RowStudyItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: StudyModel

    fun bind(item: StudyModel) {
        this.item = item
        setData()
    }

    private fun setData() {
        binding.tvLevel.text = item.level
        binding.tvName.text = item.name
        binding.tvSchool.text = item.school
        binding.tvDate.text = "${item.initDate} · ${item.endDate}"
    }

    companion object {
        fun from(parent: ViewGroup): StudyViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                RowStudyItemBinding.inflate(layoutInflater, parent, false)
            return StudyViewHolder(binding)
        }
    }
}