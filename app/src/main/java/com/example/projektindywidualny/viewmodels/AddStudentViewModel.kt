package com.example.projektindywidualny.viewmodels

import androidx.lifecycle.ViewModel
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.models.Student

class AddStudentViewModel : ViewModel() {
    private val repository = MainActivity.repository
    var firstNamePlainText: String? = null
    var lastNamePlainText: String? = null
    var classPlainText: String? = null
    fun addStudent() {
        repository.addStudent(Student(firstNamePlainText!!, lastNamePlainText!!, classPlainText!!))
    }

}