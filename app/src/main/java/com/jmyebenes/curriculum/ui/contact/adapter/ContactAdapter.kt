package com.jmyebenes.curriculum.ui.contact.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jmyebenes.curriculum.domain.model.ContactModel

class ContactAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var contactList = listOf<ContactModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ContactViewHolder)?.bind(contactList[position])
    }

    override fun getItemCount() = contactList.size

    fun setData(contactList: List<ContactModel>) {
        this.contactList = contactList
        notifyDataSetChanged()
    }
}