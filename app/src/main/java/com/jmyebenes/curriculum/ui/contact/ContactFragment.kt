package com.jmyebenes.curriculum.ui.contact

import com.jmyebenes.curriculum.databinding.FragmentContactBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.contact.adapter.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : BaseFragment<ContactViewModel, FragmentContactBinding>() {

    private lateinit var adapter: ContactAdapter

    override fun initView() {
        adapter = ContactAdapter()
        binding.rvContactList.adapter = adapter
    }

    override fun setObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            showLoader(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            showError(it)
        }
    }

    override fun getViewModelClass(): Class<ContactViewModel> = ContactViewModel::class.java
    override fun getViewBinding(): FragmentContactBinding = FragmentContactBinding.inflate(layoutInflater)
}