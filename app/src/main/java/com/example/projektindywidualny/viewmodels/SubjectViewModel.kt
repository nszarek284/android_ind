package com.example.projektindywidualny.viewmodels

import androidx.lifecycle.ViewModel
import com.example.projektindywidualny.MainActivity

class SubjectViewModel() : ViewModel() {
    val database = MainActivity.database
    val subjects = database.getSubjects().all()



}