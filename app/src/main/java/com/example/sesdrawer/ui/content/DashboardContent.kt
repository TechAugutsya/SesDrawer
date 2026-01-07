package com.example.sesdrawer.ui.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sesdrawer.ui.component.FeatureCard
import com.example.sesdrawer.ui.component.WelcomeHeader
import com.example.sesdrawer.viewmodel.DrawerUiState

@Composable
fun DashboardContent(
    modifier: Modifier = Modifier,
    uiState: DrawerUiState,
    onOpenDrawer: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        // Welcome Header
        WelcomeHeader(uiState)

        Spacer(modifier = Modifier.height(30.dp))

        // Getting Started Card
        FeatureCard(onOpenDrawer)

        Spacer(modifier = Modifier.height(24.dp))

    }
}