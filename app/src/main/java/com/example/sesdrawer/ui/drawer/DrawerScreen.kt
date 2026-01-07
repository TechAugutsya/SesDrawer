package com.example.sesdrawer.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sesdrawer.ui.content.DrawerContent
import com.example.sesdrawer.viewmodel.DrawerUiState
import com.example.sesdrawer.viewmodel.DrawerViewModel

@Composable
fun DrawerScreen(
    viewModel: DrawerViewModel = viewModel()
) {
    ModalDrawerSheet(
        modifier = Modifier.padding(end = 60.dp)
    ) {
        when (val state = viewModel.uiState) {

            is DrawerUiState.Loading -> {
                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is DrawerUiState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = state.message,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Button(onClick = { viewModel.fetchDrawerData() }) {
                        Text("Retry")
                    }
                }
            }

            is DrawerUiState.Success -> {
                DrawerContent(
                    user = state.user,
                    sections = state.sections,
                    expanded = viewModel.isAppsExpanded,
                    onSeeMore = viewModel::onSeeMoreClicked
                )
            }
        }
    }
}
