package com.example.projektindywidualny.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.R
import com.example.projektindywidualny.models.Student
import kotlinx.android.synthetic.main.fragment_students.view.*

class StudentsAdapter(private val data:LiveData<List<Student>>) : RecyclerView.Adapter<StudentsAdapter.StudentsListViewHolder>() {
    val repository = MainActivity.repository

    inner class StudentsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var model: Student? = null

        val firstName: TextView = view.findViewById(R.id.nameStudent)
        val lastName: TextView = view.findViewById(R.id.lastNameStudent)
        val classStudent: TextView = view.findViewById(R.id.classStudent)
        val deleteBtn: ImageButton = view.findViewById(R.id.deleteStudent)
        val editBtn: ImageButton = view.findViewById(R.id.editStudent)

        init {
            editBtn.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_studentsFragment_to_editStudentFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.value?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_students, parent, false)
        return StudentsListViewHolder(view)
    }

    override fun onBindViewHolder(holderStudentsList: StudentsListViewHolder, position: Int) {
        val student = data.value?.get(position)

        holderStudentsList.model = student
        holderStudentsList.firstName.text = student?.firstName
        holderStudentsList.lastName.text = student?.lastName
        holderStudentsList.classStudent.text = student?.studentClass
        holderStudentsList.deleteBtn.setOnClickListener {
            student?.let { repository.deleteStudent(it) }
        }
    }

}