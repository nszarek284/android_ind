package com.example.projektindywidualny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.projektindywidualny.repository.AppDatabase
import com.example.projektindywidualny.repository.AppRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "teacherAssistant").build()
        repository = AppRepository()
    }
    companion object {
        lateinit var database: AppDatabase
        lateinit var repository: AppRepository
    }
}