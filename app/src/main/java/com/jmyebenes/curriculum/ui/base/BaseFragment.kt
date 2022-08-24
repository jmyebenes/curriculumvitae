package com.jmyebenes.curriculum.ui.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.jmyebenes.curriculum.ui.MainActivity

abstract class BaseFragment : Fragment() {

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