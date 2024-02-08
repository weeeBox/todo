package com.example.todo.compose.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.R
import com.example.todo.data.ToDoItem

@Composable
fun HomeScreen(
  modifier: Modifier = Modifier,
  viewModel: HomeViewModel = hiltViewModel(),
) {
  val items by viewModel.items.collectAsState()

  Scaffold(
    modifier = modifier,
    topBar = {
      HomeTopAppBar()
    }
  ) { contentPadding ->
    HomePagerScreen(
      items = items,
      onItemCheckedChange = viewModel::onItemCheckedChange,
      modifier = Modifier.padding(top = contentPadding.calculateTopPadding())
    )
  }
}

@Composable
fun HomePagerScreen(
  items: List<ToDoItem>, onItemCheckedChange: (String, Boolean) -> Unit,
  modifier: Modifier = Modifier,
) {
  LazyColumn {
    items(items) { item ->
      ToDoItemRow(item = item) { checked ->
        onItemCheckedChange(item.id, checked)
      }
    }
  }
}

@Composable
fun ToDoList(items: List<ToDoItem>, onItemCheckedChange: (String, Boolean) -> Unit) {
  LazyColumn {
    items(items) { item ->
      ToDoItemRow(item = item) { checked ->
        onItemCheckedChange(item.id, checked)
      }
    }
  }
}

@Composable
fun ToDoItemRow(item: ToDoItem, onCheckedChange: (Boolean) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Checkbox(
      checked = item.isCompleted,
      onCheckedChange = { onCheckedChange(it) },
      modifier = Modifier.padding(end = 16.dp)
    )
    Text(text = item.title, modifier = Modifier.weight(1f))
  }
}

@Preview
@Composable
fun PreviewToDoList() {
  val items = remember {
    mutableStateListOf(
      ToDoItem("1", "Item 1", false, timestamp = 0L),
      ToDoItem("2", "Item 2", false, timestamp = 0L),
      ToDoItem("3", "Item 3", true, timestamp = 0L)
    )
  }
  ToDoList(items = items) { itemId, checked ->

  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar(
  modifier: Modifier = Modifier,
) {
  CenterAlignedTopAppBar(
    title = {
      Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
      ) {
        Text(
          text = stringResource(id = R.string.app_name),
          style = MaterialTheme.typography.displaySmall
        )
      }
    },
    modifier = modifier,
  )
}
