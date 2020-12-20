package com.example.projektindywidualny.viewmodels

import androidx.lifecycle.ViewModel
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.models.Student

class EditStudentViewModel : ViewModel() {
    private val repository = MainActivity.repository
    var firstNamePlainText: String? = null
    var lastNamePlainText: String? = null
    var classPlainText: String? = null

    fun updateStudent(updatedStudent: Student) {
        repository.updateStudent(Student(firstNamePlainText!!, lastNamePlainText!!, classPlainText!!))
    }
}