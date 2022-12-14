package com.d121201051.task.repository

import androidx.lifecycle.LiveData
import com.d121201051.task.data.TaskDAO
import com.d121201051.task.model.Task

class TaskRepository (private val taskDAO: TaskDAO) {
    val readAllData: LiveData<List<Task>> = taskDAO.readAllData()
    val readAllDataHistory: LiveData<List<Task>> = taskDAO.readAllDataHistory()

    suspend fun addTask(task: Task) {
        taskDAO.addTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDAO.updateTask(task)
    }
}