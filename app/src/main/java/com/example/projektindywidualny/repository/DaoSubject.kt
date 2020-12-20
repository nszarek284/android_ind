package com.example.projektindywidualny.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projektindywidualny.models.Subject

@Dao
interface DaoSubject {
    @Query("SELECT * FROM subjects")
    fun all(): LiveData<List<Subject>>

    @Query("SELECT * FROM subjects WHERE id IN (:IDs)")
    fun getByID(IDs: IntArray): LiveData<List<Subject>>

    @Query("SELECT * FROM subjects WHERE name LIKE :name LIMIT 1")
    fun getByName(name: String): Subject

    @Insert
    fun insert(vararg subject: Subject)

    @Update
    fun update(subject: Subject)

    @Delete
    fun delete(subject: Subject)
}