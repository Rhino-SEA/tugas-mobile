package com.d121201051.task.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.d121201051.task.data.TaskDataBase
import com.d121201051.task.model.Task
import com.d121201051.task.repository.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel (application: Application):AndroidViewModel(application) {
    private val repository:TaskRepository
    val readAllData: LiveData<List<Task>>
    val readAllDataHistory: LiveData<List<Task>>

    init {
        val taskDAO = TaskDataBase.getDatabase(application).taskDAO()
        repository = TaskRepository(taskDAO)
        readAllData = repository.readAllData
        readAllDataHistory = repository.readAllDataHistory
    }

    fun addTask(task: Task) {
        viewModelScope.launch (Dispatchers.IO){
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch (Dispatchers.IO){
            repository.updateTask(task)
        }
    }
}