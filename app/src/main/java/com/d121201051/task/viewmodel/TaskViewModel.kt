package com.d121201051.task.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.d121201051.task.data.TaskDataBase
import com.d121201051.task.model.Task
import com.d121201051.task.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel (application: Application):AndroidViewModel(application) {
    private val repository:TaskRepository
    init {
        val taskDAO = TaskDataBase.getDatabase(application).taskDAO()
        repository = TaskRepository(taskDAO)
    }

    fun addTask(task: Task) {
        viewModelScope.launch (Dispatchers.IO){
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {  }
    }
}