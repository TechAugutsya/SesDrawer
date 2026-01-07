package com.example.sesdrawer.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesdrawer.viewmodel.DrawerUiState

@Composable
fun WelcomeHeader(uiState: DrawerUiState) {
    val name = when (uiState) {
        is DrawerUiState.Success -> uiState.user.displayname
        else -> "Guest"
    }

    Column {
        Text(
            text = buildAnnotatedString {
                append("Hello, ")
                withStyle(
                    style = SpanStyle(color = Color(0xFF38BDF8))
                ) {
                    append(name)
                }
                append("!")
            },
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Explore your personalized apps and settings.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


@Composable
fun FeatureCard(onOpenDrawer: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Getting Started",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF1976D2)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Swipe from the left edge or click the menu icon to explore the new Navigation Drawer.",
                fontSize = 14.sp,
                color = Color(0xFF1976D2).copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onOpenDrawer,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Open Drawer")
            }
        }
    }
}

