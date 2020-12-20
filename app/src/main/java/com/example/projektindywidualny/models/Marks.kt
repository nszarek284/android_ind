package com.example.projektindywidualny.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marks")
class Marks(val mark: Double) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0;
}