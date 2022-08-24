package com.jmyebenes.curriculum.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jmyebenes.curriculum.core.ConcurrencyManager
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun executeCoroutine(
        onSuccess: suspend CoroutineScope.() -> Unit,
        onError: suspend CoroutineScope.(Throwable) -> Unit
    ): Job {
        return ConcurrencyManager().launch(fullException = false) {
            kotlin.runCatching {
                onSuccess()
            }.onFailure {
                if (it !is CancellationException) onError(it)
                else throw it
            }
        }
    }

    fun showLoading(isLoading: Boolean) {
        _loading.value = isLoading
    }

    fun showError(errorMessage: String) {
        _error.value = errorMessage
    }
}