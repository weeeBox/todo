package com.example.todo.data

import javax.inject.Inject

class ToDoItemRepository @Inject constructor(private val dao: ToDoItemDao) {
  fun getItems() = dao.getItems()
}