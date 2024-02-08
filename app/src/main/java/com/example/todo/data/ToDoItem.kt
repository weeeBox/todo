package com.example.todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ToDoItem(
  @PrimaryKey val id: String,
  @ColumnInfo(name = "title") val title: String,
  @ColumnInfo(name = "completed") val isCompleted: Boolean,
  @ColumnInfo(name = "timestamp") val timestamp: Long,
)
