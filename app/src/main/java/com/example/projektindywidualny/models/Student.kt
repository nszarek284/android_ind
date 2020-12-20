package com.example.projektindywidualny.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "students")
class Student(val firstName:String, val lastName:String, val studentClass:String? = null) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    override fun toString(): String {
        return "$firstName $lastName"
    }
}