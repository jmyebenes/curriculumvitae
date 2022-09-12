package com.jmyebenes.curriculum.ui.work

import androidx.navigation.fragment.navArgs
import com.jmyebenes.curriculum.databinding.FragmentWorkDetailBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.work.adapter.ProjectSimpleAdapter

class WorkDetailFragment : BaseFragment<WorkDetailViewModel, FragmentWorkDetailBinding>() {

    private lateinit var adapter: ProjectSimpleAdapter

    private val args: WorkDetailFragmentArgs by navArgs()

    override fun initView() {
        setToolbarTitle(args.workModel.name)
        binding.tvText.text = args.workModel.description

        adapter = ProjectSimpleAdapter { projectModel -> onProjectTappedListener(projectModel) }
        binding.rvProjectList.adapter = adapter
        adapter.setData(args.workModel.projects)
    }

    private fun onProjectTappedListener(item: ProjectModel) {
        goTo(WorkDetailFragmentDirections.actionWorkDetailFragmentToProjectDetailFragment(item))
    }

    override fun getViewModelClass(): Class<WorkDetailViewModel> = WorkDetailViewModel::class.java
    override fun getViewBinding(): FragmentWorkDetailBinding = FragmentWorkDetailBinding.inflate(layoutInflater)
}