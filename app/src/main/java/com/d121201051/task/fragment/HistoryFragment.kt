package com.d121201051.task.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121201051.task.adapter.TaskAdapter
import com.d121201051.task.databinding.FragmentHistoryBinding
import com.d121201051.task.viewmodel.TaskViewModel

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding?= null
    private val binding get() = _binding!!
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater,container,false)
        val view = binding.root
        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        val adapterTask = TaskAdapter()
        binding.recycleTugas.adapter = adapterTask
        binding.recycleTugas.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        taskViewModel.readAllDataHistory.observe(viewLifecycleOwner){task->
            adapterTask.setData(task)
        }
        return view
    }
}