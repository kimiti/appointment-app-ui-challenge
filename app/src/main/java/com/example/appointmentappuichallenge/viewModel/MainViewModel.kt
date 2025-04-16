package com.example.appointmentappuichallenge.viewModel

import androidx.lifecycle.ViewModel
import com.example.appointmentappuichallenge.repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()
    fun loadDoctors() = repository.doctors
}