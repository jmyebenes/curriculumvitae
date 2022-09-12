package com.jmyebenes.curriculum.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jmyebenes.curriculum.domain.GetAboutDataUseCase
import com.jmyebenes.curriculum.domain.model.AboutModel
import com.jmyebenes.curriculum.ui.base.BaseViewModel

class AboutViewModel : BaseViewModel() {

    private val _data = MutableLiveData<AboutModel>()
    val data: LiveData<AboutModel> = _data

    override fun init() {
        showLoading(true)
        executeCoroutine(
            onSuccess = {
                val data = GetAboutDataUseCase().execute(Unit)
                _data.value = data
                showLoading(false)
            },
            onError = {
                showError("Error getting About data")
                showLoading(false)
            })
    }
}