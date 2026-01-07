package com.example.sesdrawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sesdrawer.ui.content.DashboardContent
import com.example.sesdrawer.ui.drawer.DrawerScreen
import com.example.sesdrawer.viewmodel.DrawerUiState
import com.example.sesdrawer.viewmodel.DrawerViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val viewModel = viewModel<DrawerViewModel>()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerScreen(viewModel)
        }
    ) {
        Scaffold(
            topBar = {
                DashboardTopBar(
                    onMenuClick = { scope.launch { drawerState.open() } }
                )
            },
            containerColor = Color(0xFFF7F8FA)
        ) { innerPadding ->
            DashboardContent(
                modifier = Modifier.padding(innerPadding),
                uiState = viewModel.uiState,
                onOpenDrawer = { scope.launch { drawerState.open() } }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = { Text("Dashboard", fontWeight = FontWeight.Bold, color = Color.Black) },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open Drawer",
                    tint = Color.Black
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Color.Black
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}
