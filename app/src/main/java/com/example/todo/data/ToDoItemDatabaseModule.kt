package com.example.todo.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ToDoItemDatabaseModule {
  @Singleton
  @Provides
  fun provideDatabase(@ApplicationContext context: Context): ToDoItemDatabase =
    ToDoItemDatabase.getInstance(context = context)

  @Provides
  fun provideFoo(database: ToDoItemDatabase): ToDoItemDao = database.toDoItemDao()
}