package com.jmyebenes.curriculum.ui.studies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jmyebenes.curriculum.domain.GetStudiesDataUseCase
import com.jmyebenes.curriculum.domain.model.StudyModel
import com.jmyebenes.curriculum.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StudiesViewModel @Inject constructor(private val getStudiesDataUseCase: GetStudiesDataUseCase) :
    BaseViewModel() {

    private val _data = MutableLiveData<List<StudyModel>>()
    val data: LiveData<List<StudyModel>> = _data

    override fun init() {
        showLoading(true)
        executeCoroutine(
            onSuccess = {
                val data = getStudiesDataUseCase.execute(Unit)
                _data.value = data
                showLoading(false)
            },
            onError = {
                showError("Error getting Studies data")
                showLoading(false)
            })
    }

}