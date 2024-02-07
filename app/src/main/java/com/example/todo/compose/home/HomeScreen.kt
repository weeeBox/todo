package com.example.todo.compose.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.R
import com.example.todo.ui.theme.ToDoTheme

@Composable
fun HomeScreen(
  modifier: Modifier = Modifier,
  viewModel: HomeViewModel = viewModel(),
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      HomeTopAppBar()
    }
  ) { contentPadding ->
    HomePagerScreen(
      Modifier.padding(top = contentPadding.calculateTopPadding())
    )
  }
}

@Composable
fun HomePagerScreen(
  modifier: Modifier = Modifier,
) {
  Text(
    text = "Home page",
    modifier = modifier
  )
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

@Preview
@Composable
private fun HomeScreenPreview() {
  ToDoTheme {
    HomePagerScreen(
    )
  }
}
