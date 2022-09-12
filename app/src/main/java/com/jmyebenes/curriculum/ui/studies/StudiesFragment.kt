package com.jmyebenes.curriculum.ui.studies

import com.jmyebenes.curriculum.databinding.FragmentStudiesBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.studies.adapter.StudyAdapter

class StudiesFragment : BaseFragment<StudiesViewModel, FragmentStudiesBinding>() {

    private lateinit var adapter: StudyAdapter

    override fun initView() {
        adapter = StudyAdapter()
        binding.rvStudiesList.adapter = adapter
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

    override fun getViewModelClass(): Class<StudiesViewModel> = StudiesViewModel::class.java
    override fun getViewBinding(): FragmentStudiesBinding = FragmentStudiesBinding.inflate(layoutInflater)
}