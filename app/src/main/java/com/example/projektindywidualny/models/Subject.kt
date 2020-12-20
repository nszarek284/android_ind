package com.example.projektindywidualny.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
class Subject(val name:String) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0;
}