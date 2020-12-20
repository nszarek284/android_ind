package com.example.projektindywidualny.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projektindywidualny.models.Marks
import com.example.projektindywidualny.models.Student
import com.example.projektindywidualny.models.Subject

@Database(entities = [Student::class, Subject::class, Marks::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getStudents(): DaoStudent
    abstract fun getSubjects(): DaoSubject
    abstract fun getMarks(): DaoMark
}