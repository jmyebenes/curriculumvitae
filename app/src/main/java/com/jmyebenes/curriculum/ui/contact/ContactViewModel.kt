package com.jmyebenes.curriculum.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jmyebenes.curriculum.domain.GetContactDataUseCase
import com.jmyebenes.curriculum.domain.model.ContactModel
import com.jmyebenes.curriculum.ui.base.BaseViewModel

class ContactViewModel : BaseViewModel() {

    private val _data = MutableLiveData<List<ContactModel>>()
    val data: LiveData<List<ContactModel>> = _data

    fun init() {
        showLoading(true)
        executeCoroutine(
            onSuccess = {
                val data = GetContactDataUseCase().execute(Unit)
                _data.value = data
                showLoading(false)
            },
            onError = {
                showError("Error getting Contact data")
                showLoading(false)
            })
    }

}