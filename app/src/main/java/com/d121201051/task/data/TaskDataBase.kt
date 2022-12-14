package com.d121201051.task.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.d121201051.task.model.Task
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDataBase: RoomDatabase() {
    abstract fun taskDAO():TaskDAO

    companion object{
        @Volatile
        private var INSTANCE:TaskDataBase ?= null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context):TaskDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}