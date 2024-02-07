package com.example.todo.compose.itemdetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.ui.theme.ToDoTheme

@Composable
fun ItemDetailScreen(
  viewModel: ItemDetailViewModel = viewModel(),
) {
}

@Preview
@Composable
private fun ItemDetailScreenPreview() {
  ToDoTheme {

  }
}