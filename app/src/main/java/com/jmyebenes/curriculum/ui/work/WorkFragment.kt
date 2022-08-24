package com.jmyebenes.curriculum.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jmyebenes.curriculum.databinding.FragmentWorkBinding
import com.jmyebenes.curriculum.domain.model.ProjectModel
import com.jmyebenes.curriculum.domain.model.WorkModel
import com.jmyebenes.curriculum.ui.base.BaseFragment
import com.jmyebenes.curriculum.ui.work.adapter.WorkAdapter

class WorkFragment : BaseFragment() {

    private lateinit var viewModel: WorkViewModel
    private lateinit var binding: FragmentWorkBinding

    private lateinit var adapter: WorkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[WorkViewModel::class.java]

        initView()
        setObservers()
        setListeners()

        viewModel.init()
    }

    private fun initView() {
        adapter = WorkAdapter(
            { workModel -> onWorkTappedListener(workModel) },
            { projectModel -> onProjectTappedListener(projectModel) }
        )
        binding.rvWorkList.adapter = adapter
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

    private fun onWorkTappedListener(item: WorkModel) {
        goTo(WorkFragmentDirections.actionNavigationWorkToWorkDetailFragment(item))
    }

    private fun onProjectTappedListener(item: ProjectModel) {
        goTo(WorkFragmentDirections.actionNavigationWorkToProjectDetailFragment(item))
    }
}