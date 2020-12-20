package com.example.projektindywidualny.repository

import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.models.Student
import com.example.projektindywidualny.models.Subject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppRepository {
    val database = MainActivity.database
    fun deleteSubject(subject: Subject) {
        GlobalScope.launch {
            database.getSubjects().delete(subject)
        }
    }

    fun deleteStudent(student: Student) {
        GlobalScope.launch {
            database.getStudents().delete(student)
        }
    }

    fun addSubject(vararg subject: Subject) {
        GlobalScope.launch {
            database.getSubjects().insert(*subject)
        }
    }

    fun addStudent(vararg student: Student) {
        GlobalScope.launch {
            database.getStudents().insert(*student)
        }
    }

    fun updateSubject(subject: Subject) {
        GlobalScope.launch {
            database.getSubjects().update(subject)
        }
    }

    fun updateStudent(student: Student) {
        GlobalScope.launch {
            database.getStudents().update(student)
        }
    }
}