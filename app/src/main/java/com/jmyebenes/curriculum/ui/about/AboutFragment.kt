package com.jmyebenes.curriculum.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jmyebenes.curriculum.core.extensions.loadImage
import com.jmyebenes.curriculum.databinding.FragmentAboutBinding
import com.jmyebenes.curriculum.ui.base.BaseFragment

class AboutFragment : BaseFragment() {

    private lateinit var viewModel: AboutViewModel
    private lateinit var binding: FragmentAboutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[AboutViewModel::class.java]

        setObservers()
        setListeners()

        viewModel.init()
    }

    private fun setObservers() {
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

    private fun setListeners() {

    }
}