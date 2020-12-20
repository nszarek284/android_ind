package com.example.projektindywidualny.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.projektindywidualny.R
import com.example.projektindywidualny.models.Student

//to nie jest zrobione, skopiowałam kod z innego adaptera

class AddSubjectAdapter(private val data:MutableList<Student>) : RecyclerView.Adapter<AddSubjectAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val firstName: TextView = view.findViewById(R.id.firstNameStudent)
        val lastName: TextView = view.findViewById(R.id.lastNameStudent)
        val classStudent: TextView = view.findViewById(R.id.studentClass)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_subject, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val students = data[position]
        holder.firstName.text = students.firstName
        holder.lastName.text = students.lastName
        holder.classStudent.text = students.studentClass
    }

    override fun getItemCount(): Int {
        return data.size
    }

}