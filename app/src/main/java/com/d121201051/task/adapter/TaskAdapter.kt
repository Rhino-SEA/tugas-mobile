package com.d121201051.task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.d121201051.task.R
import com.d121201051.task.model.Task

class TaskAdapter:RecyclerView.Adapter<TaskAdapter.TaskAdapterViewHolder>() {
    private var listTask= emptyList<Task>()

    class TaskAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val judul:TextView = itemView.findViewById(R.id.judul_tugas)
        val isi:TextView = itemView.findViewById(R.id.deskripsi_tugas)
        val kategori:TextView = itemView.findViewById(R.id.kategori_tugas)
        val klik:TextView = itemView.findViewById(R.id.card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapterViewHolder {
        TODO("Not yet implemented")
        return TaskAdapterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_task,parent,false))
    }

    override fun onBindViewHolder(holder: TaskAdapterViewHolder, position: Int) {
        TODO("Not yet implemented")
        val currentTask = listTask[position]
        holder.judul.text = currentTask.judul
        holder.isi.text = currentTask.deskripsi
        holder.kategori.text = currentTask.category
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return listTask.size
    }
}