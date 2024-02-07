package com.example.todo.compose.itemadd

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.ui.theme.ToDoTheme

@Composable
fun ItemAddScreen(
  viewModel: ItemAddViewModel = viewModel(),
) {
}

@Preview
@Composable
private fun ItemAddScreenPreview() {
  ToDoTheme {

  }
}