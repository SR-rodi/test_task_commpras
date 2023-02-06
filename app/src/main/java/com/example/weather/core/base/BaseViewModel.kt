package com.example.weather.core.base

import androidx.lifecycle.ViewModel
import com.example.weather.core.LoadState
import com.example.weather.core.extension.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {

    protected val _loadState = MutableStateFlow(LoadState.LOADING)
    val loadState = _loadState.asStateFlow()

    protected val handler = CoroutineExceptionHandler { _, error ->
        Log(error)
        _loadState.value = LoadState.ERROR
    }
}