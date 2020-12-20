package com.example.projektindywidualny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.projektindywidualny.R
import com.example.projektindywidualny.viewmodels.StudentViewModel
import com.example.projektindywidualny.adapters.StudentsAdapter

class StudentsFragment : Fragment() {

    lateinit var recycler: RecyclerView
    lateinit var layoutMng: LinearLayoutManager
    lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_students_list, container, false)
        val addBtn = view.findViewById<ImageButton>(R.id.addStudents)
        recycler = view.findViewById(R.id.list)

        addBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_studentsFragment_to_addStudentFragment)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layoutMng = LinearLayoutManager(this.context)
        viewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        val adapter = StudentsAdapter(viewModel.students)

        viewModel.students.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })

        recycler.layoutManager = layoutMng
        recycler.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = StudentsFragment()
    }
}

