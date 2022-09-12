package com.jmyebenes.curriculum.ui.work

import androidx.navigation.fragment.navArgs
import com.jmyebenes.curriculum.databinding.FragmentProjectDetailBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment

class ProjectDetailFragment : BaseFragment<ProjectDetailViewModel, FragmentProjectDetailBinding>() {

    private val args: ProjectDetailFragmentArgs by navArgs()

    override fun initView() {
        setToolbarTitle(args.projectModel.name)
        binding.tvPosition.text = args.projectModel.position
        binding.tvDescription.text = args.projectModel.description
        binding.tvTechnologies.text = args.projectModel.technologies
    }

    override fun getViewModelClass(): Class<ProjectDetailViewModel> = ProjectDetailViewModel::class.java
    override fun getViewBinding(): FragmentProjectDetailBinding = FragmentProjectDetailBinding.inflate(layoutInflater)
}