package com.example.projektindywidualny.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projektindywidualny.models.Student

@Dao
interface DaoStudent {
    @Query("SELECT * FROM students")
    fun all(): LiveData<List<Student>>

    @Query("SELECT * FROM students WHERE id IN (:IDs)")
    fun getByID(IDs: IntArray): LiveData<List<Student>>

    @Query("SELECT * FROM students WHERE firstName LIKE :firstName LIMIT 1")
    fun getByName(firstName: String): Student

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg student: Student)

    @Update
    fun update(student: Student)

    @Delete
    fun delete(student: Student)
}