package com.example.projektindywidualny.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.projektindywidualny.MainActivity
import com.example.projektindywidualny.R
import com.example.projektindywidualny.viewmodels.SubjectViewModel
import com.example.projektindywidualny.adapters.SubjectAdapter

/**
 * A fragment representing a list of Items.
 */
class SubjectFragment : Fragment() {
    val database = MainActivity.database
    lateinit var recycler: RecyclerView
    lateinit var layoutMng: LinearLayoutManager
    private lateinit var viewModel: SubjectViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_subject_list, container, false)
        recycler = view.findViewById(R.id.listSubject)
        val addBtn = view.findViewById<ImageButton>(R.id.add)

        addBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_subjectFragment_to_addSubjectFragment)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layoutMng = LinearLayoutManager(this.context)
        viewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)
        val adapter = SubjectAdapter(viewModel.subjects)

        viewModel.subjects.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })

        recycler.layoutManager = layoutMng
        recycler.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubjectFragment()
            }
    }
