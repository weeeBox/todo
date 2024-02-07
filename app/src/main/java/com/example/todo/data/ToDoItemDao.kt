package com.example.todo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoItemDao {
  @Query("SELECT * FROM items ORDER BY title")
  fun getItems(): Flow<List<ToDoItem>>

  @Query("SELECT * FROM items WHERE id = :itemId")
  fun getPlant(itemId: String): Flow<ToDoItem>

  @Query("DELETE * FROM items WHERE id = :itemId")
  suspend fun deleteItem(itemId: String)

  @Insert
  suspend fun insertItem(item: ToDoItem)

  @Update
  suspend fun updateItem(item: ToDoItem)
}
