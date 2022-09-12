package com.jmyebenes.curriculum.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jmyebenes.curriculum.domain.GetAboutDataUseCase
import com.jmyebenes.curriculum.domain.model.AboutModel
import com.jmyebenes.curriculum.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(private val getAboutDataUseCase: GetAboutDataUseCase) :
    BaseViewModel() {

    private val _data = MutableLiveData<AboutModel>()
    val data: LiveData<AboutModel> = _data

    override fun init() {
        showLoading(true)
        executeCoroutine(
            onSuccess = {
                val data = getAboutDataUseCase.execute(Unit)
                _data.value = data
                showLoading(false)
            },
            onError = {
                showError("Error getting About data")
                showLoading(false)
            })
    }
}