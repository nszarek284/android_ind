package com.example.projektindywidualny.viewmodels

import androidx.lifecycle.ViewModel
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.models.Subject

class AddSubjectViewModel : ViewModel() {
    private val repository = MainActivity.repository
    var subjectName: String? = null
    fun addSubject() {
        repository.addSubject(Subject(subjectName!!))
    }
}