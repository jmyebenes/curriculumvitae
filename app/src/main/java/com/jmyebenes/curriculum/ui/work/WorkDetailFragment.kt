package com.jmyebenes.curriculum.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jmyebenes.curriculum.databinding.FragmentWorkDetailBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.work.adapter.ProjectSimpleAdapter

class WorkDetailFragment : BaseFragment() {

    //    private lateinit var viewModel: WorkViewModel
    private lateinit var binding: FragmentWorkDetailBinding

    private lateinit var adapter: ProjectSimpleAdapter

    private val args: WorkDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this)[WorkViewModel::class.java]

        initView()
        setObservers()
        setListeners()

//        viewModel.init()
    }

    private fun initView() {
        setToolbarTitle(args.workModel.name)
        binding.tvText.text = args.workModel.description

        adapter = ProjectSimpleAdapter { projectModel -> onProjectTappedListener(projectModel) }
        binding.rvProjectList.adapter = adapter
        adapter.setData(args.workModel.projects)
    }

    private fun setObservers() {

    }

    private fun setListeners() {

    }

    private fun onProjectTappedListener(item: ProjectModel) {
        goTo(WorkDetailFragmentDirections.actionWorkDetailFragmentToProjectDetailFragment(item))
    }
}