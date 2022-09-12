package com.jmyebenes.curriculum.ui.work

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jmyebenes.curriculum.domain.GetWorkDataUseCase
import com.jmyebenes.curriculum.domain.model.WorkModel
import com.jmyebenes.curriculum.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkViewModel @Inject constructor(private val getWorkDataUseCase: GetWorkDataUseCase) :
    BaseViewModel() {

    private val _data = MutableLiveData<List<WorkModel>>()
    val data: LiveData<List<WorkModel>> = _data

    override fun init() {
        showLoading(true)
        executeCoroutine(
            onSuccess = {
                val data = getWorkDataUseCase.execute(Unit)
                _data.value = data
                showLoading(false)
            },
            onError = {
                showError("Error getting Work data")
                showLoading(false)
            })
    }

}