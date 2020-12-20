package com.example.projektindywidualny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.viewmodels.AddStudentViewModel
import com.example.projektindywidualny.R
import com.example.projektindywidualny.models.Student
import com.example.projektindywidualny.databinding.AddStudentFragmentBinding

class AddStudentFragment : Fragment() {
    companion object {
        fun newInstance() = AddStudentFragment()
        fun newInstance(student: Student): AddStudentFragment {
            val studentFragment = AddStudentFragment()
            studentFragment.viewModel.firstNamePlainText = student.firstName
            studentFragment.viewModel.lastNamePlainText = student.lastName
            studentFragment.viewModel.classPlainText = student.studentClass

            return studentFragment
        }
    }

    private val viewModel: AddStudentViewModel by lazy {
        ViewModelProvider(this).get(AddStudentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = AddStudentFragmentBinding.inflate(LayoutInflater.from(context)).also {
            it.viewModel = viewModel
        }.root
        val saveBtn = view.findViewById<Button>(R.id.saveStudent)
        val fName = view.findViewById<EditText>(R.id.firstNamePlainText)
            val lname = view.findViewById<EditText>(R.id.lastNamePlainText)
            val studentClass = view.findViewById<EditText>(R.id.classStudent)

            saveBtn.setOnClickListener {
                if (!fName.text.isNullOrBlank() && !lname.text.isNullOrBlank()) {
                        viewModel.addStudent()
                    Toast.makeText(requireContext(), "Dodano",Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(view)
                        .navigate(R.id.action_addStudentFragment_to_studentsFragment)
                }
            }
            return view
        }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}