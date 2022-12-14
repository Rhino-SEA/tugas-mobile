package com.d121201051.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.d121201051.task.databinding.ActivityAddBinding
import com.d121201051.task.databinding.ActivityMainBinding
import com.d121201051.task.model.Task
import com.d121201051.task.viewmodel.TaskViewModel
import kotlinx.coroutines.launch

class Add_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private lateinit var kategoriTugas:ArrayAdapter<CharSequence>
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        kategoriTugas = ArrayAdapter.createFromResource(this,R.array.category_tugas,android.R.layout.simple_expandable_list_item_1)
        binding.optionCategoryTugas.setAdapter(kategoriTugas)

        binding.addBtn.setOnClickListener {
            val judul = binding.judulTugas.text.toString()
            val isi = binding.deskripsiTugas.text.toString()
            val kategori = binding.optionCategoryTugas.text.toString()

            if (kategori.isEmpty()) {
                Toast.makeText(
                    this,
                    "Kategori wajib diisi",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (judul.isEmpty()) {
                binding.judulTugas.error = "Judul tidak boleh kosong"
                binding.judulTugas.requestFocus()
                return@setOnClickListener
            }

            if (isi.isEmpty()) {
                binding.deskripsiTugas.error = "Deskripsi tugas masih kosong"
                binding.deskripsiTugas.requestFocus()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val task = Task(0,judul,isi,kategori,"On Progress")
                taskViewModel.addTask(task)
                finish()
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}