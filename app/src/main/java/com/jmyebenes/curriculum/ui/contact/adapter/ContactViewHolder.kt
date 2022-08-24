package com.jmyebenes.curriculum.ui.contact.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.core.extensions.browse
import com.jmyebenes.curriculum.core.extensions.call
import com.jmyebenes.curriculum.core.extensions.loadImage
import com.jmyebenes.curriculum.core.extensions.mail
import com.jmyebenes.curriculum.databinding.RowContactItemBinding
import com.jmyebenes.curriculum.domain.model.ContactModel
import com.jmyebenes.curriculum.domain.model.ContactType

class ContactViewHolder private constructor(val binding: RowContactItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: ContactModel

    fun bind(item: ContactModel) {
        this.item = item
        setData()
        setListeners()
    }

    private fun setData() {
        binding.ivLogo.loadImage(item.image)
        binding.tvText.text = item.text
    }

    private fun setListeners() {
        binding.root.setOnClickListener {
            onItemTapped()
        }
    }

    private fun onItemTapped() {
        with(binding.root.context) {
            when (item.type) {
                ContactType.TEL -> call(item.text)
                ContactType.MAIL -> mail(item.text)
                ContactType.LINK -> browse(item.text)
                ContactType.UNKNOWN -> {}
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup): ContactViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding =
                RowContactItemBinding.inflate(layoutInflater, parent, false)
            return ContactViewHolder(binding)
        }
    }
}