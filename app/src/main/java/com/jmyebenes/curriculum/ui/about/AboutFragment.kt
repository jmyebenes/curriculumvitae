package com.jmyebenes.curriculum.ui.about

import com.jmyebenes.curriculum.core.extensions.loadImage
import com.jmyebenes.curriculum.databinding.FragmentAboutBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : BaseFragment<AboutViewModel, FragmentAboutBinding>() {

    override fun setObservers() {
        viewModel.data.observe(viewLifecycleOwner) {
            binding.tvTitle.text = it.title
            binding.tvLocation.text = it.location
            binding.tvDescription.text = it.description
            binding.ivAvatar.loadImage(it.image)
        }
        viewModel.loading.observe(viewLifecycleOwner) {
            showLoader(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            showError(it)
        }
    }

    override fun getViewModelClass(): Class<AboutViewModel> = AboutViewModel::class.java
    override fun getViewBinding(): FragmentAboutBinding = FragmentAboutBinding.inflate(layoutInflater)
}