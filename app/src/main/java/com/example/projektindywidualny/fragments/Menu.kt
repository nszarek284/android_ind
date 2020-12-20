package com.example.projektindywidualny.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.projektindywidualny.R
import com.example.projektindywidualny.R.*
import com.example.projektindywidualny.viewmodels.MenuViewModel

class Menu : Fragment() {

    companion object {
        fun newInstance() = Menu()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout.menu_fragment, container, false)

        val subjectBtn = view.findViewById<Button>(R.id.subjects)
        val studentBtn = view.findViewById<Button>(R.id.students)
        val markBtn = view.findViewById<Button>(R.id.marks)
        val reportBtn = view.findViewById<Button>(R.id.report)

        subjectBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_menu_to_subjectFragment)
        }

        studentBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_menu_to_studentsFragment)
        }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}