package com.example.andrewmoney.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.andrewmoney.data.repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel (private val repository: AppRepository) : ViewModel() {
    init {
        viewModelScope.launch() {
            repository.getLatestVaults()
        }
    }

}