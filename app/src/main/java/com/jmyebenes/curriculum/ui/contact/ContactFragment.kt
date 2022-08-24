package com.jmyebenes.curriculum.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jmyebenes.curriculum.databinding.FragmentContactBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.contact.adapter.ContactAdapter

class ContactFragment : BaseFragment() {

    private lateinit var viewModel: ContactViewModel
    private lateinit var binding: FragmentContactBinding

    private lateinit var adapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ContactViewModel::class.java]

        initView()
        setObservers()
        setListeners()

        viewModel.init()
    }

    private fun initView() {
        adapter = ContactAdapter()
        binding.rvContactList.adapter = adapter
    }

    private fun setObservers() {
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

    private fun setListeners() {

    }
}