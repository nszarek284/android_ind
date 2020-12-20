package com.example.projektindywidualny.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.projektindywidualny.R
import com.example.projektindywidualny.databinding.EditStudentFragmentBinding
import com.example.projektindywidualny.models.Student
import com.example.projektindywidualny.viewmodels.EditStudentViewModel
import kotlinx.android.synthetic.main.edit_student_fragment.*
import kotlinx.android.synthetic.main.fragment_add_subject.*

class EditStudentFragment : Fragment() {
    private val args by navArgs<EditStudentFragmentArgs>()

    companion object {
        fun newInstance() = EditStudentFragment()
    }

    private val viewModel: EditStudentViewModel by lazy {
        ViewModelProvider(this).get(EditStudentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = EditStudentFragmentBinding.inflate(LayoutInflater.from(context)).also {
            it.viewModel = viewModel
        }.root

        val saveBtn = view.findViewById<Button>(R.id.saveStudent_edit)
        val fName = view.findViewById<EditText>(R.id.firstNamePlainText_edit)
        val lname = view.findViewById<EditText>(R.id.lastNamePlainText_edit)
        val studentClass = view.findViewById<EditText>(R.id.classPlainText_edit)
        fName.setText(args.currentStudent.firstName)
        lname.setText(args.currentStudent.lastName)
        studentClass.setText(args.currentStudent.studentClass)
        val idStudent = args.currentStudent.id
        saveBtn.setOnClickListener {
                updateItem(idStudent)
                Toast.makeText(requireContext(), "Edytowano", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view)
                    .navigate(R.id.action_editStudentFragment_to_studentsFragment)

        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    private fun updateItem(idStudent:Int){
        val firstName = firstNamePlainText_edit.toString()
        val lastName = lastNamePlainText_edit.toString()
        val stClass = classPlainText_edit.toString()

            // Create User Object
            val updatedStudent = Student(firstName, lastName, stClass)
            updatedStudent.id = idStudent
            viewModel.updateStudent(updatedStudent)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editStudentFragment_to_studentsFragment)
    }

}