package com.d121201051.task.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.d121201051.task.R
import com.d121201051.task.databinding.FragmentDetailBinding
import com.d121201051.task.model.Task
import com.d121201051.task.viewmodel.TaskViewModel

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding?= null
    private val binding get() = _binding!!
    private lateinit var taskViewModel: TaskViewModel
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(
            inflater,
            container,
            false
        )

        val view = binding.root
        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        binding.judulTugas.text = args.currentTask.judul
        binding.deskripsiTugas.text = args.currentTask.deskripsi
        binding.kategoriTugas.text = args.currentTask.category

        if (args.currentTask.status.equals("DONE")){
            binding.btnDone.visibility = View.GONE
            binding.btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_historyFragment)
            }
        }else{
            binding.btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            }
            binding.btnDone.setOnClickListener {
                val selesai = Task(args.currentTask.id,
                    args.currentTask.judul,
                    args.currentTask.deskripsi,
                    args.currentTask.category,
                    "DONE")
                taskViewModel.updateTask(selesai)
                findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
        return view
    }
}