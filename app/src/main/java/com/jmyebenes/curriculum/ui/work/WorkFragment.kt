package com.jmyebenes.curriculum.ui.work

import com.jmyebenes.curriculum.databinding.FragmentWorkBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel
import com.jmyebenes.curriculum.domain.model.WorkModel
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.work.adapter.WorkAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkFragment : BaseFragment<WorkViewModel, FragmentWorkBinding>() {

    private lateinit var adapter: WorkAdapter

    override fun initView() {
        adapter = WorkAdapter(
            { workModel -> onWorkTappedListener(workModel) },
            { projectModel -> onProjectTappedListener(projectModel) }
        )
        binding.rvWorkList.adapter = adapter
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

    private fun onWorkTappedListener(item: WorkModel) {
        goTo(WorkFragmentDirections.actionNavigationWorkToWorkDetailFragment(item))
    }

    private fun onProjectTappedListener(item: ProjectModel) {
        goTo(WorkFragmentDirections.actionNavigationWorkToProjectDetailFragment(item))
    }

    override fun getViewModelClass(): Class<WorkViewModel> = WorkViewModel::class.java
    override fun getViewBinding(): FragmentWorkBinding = FragmentWorkBinding.inflate(layoutInflater)
}