package com.example.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoItemDatabase : RoomDatabase() {
  abstract fun toDoItemDao(): ToDoItemDao

  companion object {

    // For Singleton instantiation
    @Volatile private var instance: ToDoItemDatabase? = null

    fun getInstance(context: Context): ToDoItemDatabase {
      return instance ?: synchronized(this) {
        instance ?: buildDatabase(context).also { instance = it }
      }
    }

    private fun buildDatabase(context: Context): ToDoItemDatabase {
      return Room.databaseBuilder(context, ToDoItemDatabase::class.java, "items-db").build()
    }
  }
}
