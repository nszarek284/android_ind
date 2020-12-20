package com.example.projektindywidualny.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "student_subject",
foreignKeys = [
    ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["id_student"],
        onDelete = ForeignKey.CASCADE
    ),
ForeignKey(
    entity = Subject::class,
    parentColumns = ["id"],
    childColumns = ["id_subject"],
    onDelete = ForeignKey.CASCADE
)
])
class StudentSubject(val id_student: Int, val id_subject: Int) {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}