package com.d121201051.task.repository

import com.d121201051.task.data.TaskDAO
import com.d121201051.task.model.Task

class TaskRepository (private val taskDAO: TaskDAO) {
    suspend fun addTask(task: Task) {
        taskDAO.addTask(task)
    }

    suspend fun updateTask(task: Task) {
        taskDAO.updateTask(task)
    }
}