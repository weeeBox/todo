package com.example.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
      return Room.databaseBuilder(context, ToDoItemDatabase::class.java, "items-db")
        .addCallback(object : Callback() {
          override fun onCreate(db: SupportSQLiteDatabase) {
            GlobalScope.launch {
              getInstance(context).toDoItemDao().apply {
                insertItem(
                  ToDoItem(
                    id = "1",
                    title = "Item 1",
                    isCompleted = false,
                    timestamp = 0L
                  )
                )
                insertItem(
                  ToDoItem(
                    id = "2",
                    title = "Item 2",
                    isCompleted = false,
                    timestamp = 0L
                  )
                )
                insertItem(
                  ToDoItem(
                    id = "3",
                    title = "Item 3",
                    isCompleted = false,
                    timestamp = 0L
                  )
                )
              }
            }
          }
        }).build()
    }
  }
}
