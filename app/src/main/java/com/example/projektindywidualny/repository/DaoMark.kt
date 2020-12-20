package com.example.projektindywidualny.repository

import androidx.room.*
import com.example.projektindywidualny.models.Marks

@Dao
interface DaoMark {
    @Query("SELECT * FROM marks")
    fun all(): List<Marks>

    @Query("SELECT * FROM marks WHERE id IN (:IDs)")
    fun getByID(IDs: IntArray): List<Marks>

    @Query("SELECT * FROM marks WHERE mark LIKE :mark LIMIT 1")
    fun getByName(mark: Double): Marks

    @Insert
    fun insert(vararg mark: Marks)

    @Update
    fun update(marks: Marks)

    @Delete
    fun delete(marks: Marks)
}