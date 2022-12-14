package com.d121201051.task.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.d121201051.task.model.Task

@Dao
interface TaskDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("SELECT * FROM task WHERE status='On Progress'")
    fun readAllData(): LiveData<List<Task>>

    @Query("SELECT * FROM task WHERE status='DONE'")
    fun readAllDataHistory(): LiveData<List<Task>>
}