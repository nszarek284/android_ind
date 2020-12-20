package com.example.projektindywidualny.viewmodels

import androidx.lifecycle.ViewModel
import com.example.projektindywidualny.MainActivity

class StudentViewModel : ViewModel() {
    val database = MainActivity.database
    val students = database.getStudents().all()
}