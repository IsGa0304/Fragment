package com.example.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedDoctor = MutableLiveData<Doctor>()
    val selectedDoctor: LiveData<Doctor> get() = _selectedDoctor

    private val _appointmentDate = MutableLiveData<String>()
    val appointmentDate: LiveData<String> get() = _appointmentDate

    fun selectDoctor(doctor: Doctor) {
        _selectedDoctor.value = doctor
    }

    fun setAppointmentDate(date: String) {
        _appointmentDate.value = date
    }
}
