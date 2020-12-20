package com.example.projektindywidualny.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.R
import com.example.projektindywidualny.models.Subject

class SubjectAdapter(private val data:LiveData<List<Subject>>) : RecyclerView.Adapter<SubjectAdapter.ViewHolder>() {

    val repository = MainActivity.repository

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subjectName: TextView = view.findViewById(R.id.nameSubject)
        val deleteSubject: ImageButton = view.findViewById(R.id.deleteSubject)
        val editSubject: ImageButton = view.findViewById(R.id.editSubject)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_subject, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subject = data.value?.get(position)

        holder.subjectName.text = subject?.name
        holder.deleteSubject.setOnClickListener {
            subject?.let { repository.deleteSubject(it) }
        }
        holder.editSubject.setOnClickListener {
            subject.let {
            }
        }
    }

    override fun getItemCount(): Int {
        return data.value?.size ?: 0
    }


}