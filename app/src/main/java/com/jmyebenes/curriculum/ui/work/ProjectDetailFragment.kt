package com.jmyebenes.curriculum.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jmyebenes.curriculum.databinding.FragmentProjectDetailBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment

class ProjectDetailFragment : BaseFragment() {

    //    private lateinit var viewModel: WorkViewModel
    private lateinit var binding: FragmentProjectDetailBinding

    private val args: ProjectDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProjectDetailBinding.inflate(inflater, container, false)
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
        setToolbarTitle(args.projectModel.name)
        binding.tvPosition.text = args.projectModel.position
        binding.tvDescription.text = args.projectModel.description
        binding.tvTechnologies.text = args.projectModel.technologies
    }

    private fun setObservers() {

    }

    private fun setListeners() {

    }
}