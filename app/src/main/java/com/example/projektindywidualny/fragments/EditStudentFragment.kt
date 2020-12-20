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
import androidx.navigation.fragment.navArgs
import com.example.projektindywidualny.R
import com.example.projektindywidualny.databinding.EditStudentFragmentBinding
import com.example.projektindywidualny.viewmodels.EditStudentViewModel

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
        saveBtn.setOnClickListener {
            if (!fName.text.isNullOrBlank() && !lname.text.isNullOrBlank()) {
                viewModel.updateStudent()
                Toast.makeText(requireContext(), "Edytowano", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view)
                    .navigate(R.id.action_editStudentFragment_to_studentsFragment)
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
   /* private fun updateItem(){
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge_et.text.toString())

        if(inputCheck(firstName, lastName, updateAge_et.text)){
            // Create User Object
            val updatedUser = User(args.currentUser.id, firstName, lastName, age)
            // Update Current User
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }*/

}