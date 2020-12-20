package com.example.projektindywidualny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.projektindywidualny.viewmodels.AddSubjectViewModel
import com.example.projektindywidualny.R
import com.example.projektindywidualny.databinding.AddSubjectFragmentListBinding

class AddSubjectFragment : Fragment() {

    companion object {
        fun newInstance() = AddSubjectFragment()
    }

    private val viewModel: AddSubjectViewModel by lazy {
        ViewModelProvider(this).get(AddSubjectViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = AddSubjectFragmentListBinding.inflate(LayoutInflater.from(context)).also {
            it.viewModel = viewModel
        }.root
        val saveBtn = view.findViewById<Button>(R.id.saveSubject)

        val nameOfSubject = view.findViewById<EditText>(R.id.nameOfSubject)

        saveBtn.setOnClickListener {
            if(!nameOfSubject.text.isNullOrEmpty()) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_addSubjectFragment_to_subjectFragment)
                viewModel.addSubject()
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}