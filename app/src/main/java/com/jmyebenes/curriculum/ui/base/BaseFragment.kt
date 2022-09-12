package com.jmyebenes.curriculum.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.jmyebenes.curriculum.ui.MainActivity

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    protected lateinit var viewModel: VM
    protected abstract fun getViewModelClass(): Class<VM>

    protected lateinit var binding: VB
    protected abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setObservers()
        setListeners()
        viewModel.init()
    }

    private fun init() {
        binding = getViewBinding()
        viewModel = ViewModelProvider(this)[getViewModelClass()]
    }

    open fun initView() {}
    open fun setObservers() {}
    open fun setListeners() {}

    fun setToolbarTitle(title: String) {
        (activity as MainActivity).setToolbarTitle(title)
    }

    fun goTo(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    fun goBack() {
        findNavController().popBackStack()
    }

    fun showLoader(show: Boolean) {
        (activity as MainActivity).showLoader(show)
    }

    fun showError(errorMessage: String) {
        (activity as MainActivity).showError(errorMessage)
    }
}