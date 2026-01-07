package com.example.sesdrawer.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesdrawer.data.model.MenuSection
import com.example.sesdrawer.data.model.User
import com.example.sesdrawer.ui.component.AppsSection
import com.example.sesdrawer.ui.component.DrawerGridItem
import com.example.sesdrawer.ui.component.ProfileSection

@Composable
fun DrawerContent(
    user: User,
    sections: List<MenuSection>,
    expanded: Boolean,
    onSeeMore: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F8FA))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Menu",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(
                    modifier = Modifier
                        .background(Color(0xFFE9EBEE), RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Language,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "IND-INR-EN",
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )
                }
                Spacer(Modifier.width(10.dp))
                Box(
                    modifier = Modifier.size(36.dp).background(Color(0xFFE9EBEE), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                }
            }
        }

        ProfileSection(user)

        Spacer(Modifier.height(16.dp))

        sections.forEach { section ->
            // Skip empty headers before Message/Notifications
            if (section.name.isEmpty() && section.items.isEmpty()) return@forEach
            
            if (section.name.contains("APPS", ignoreCase = true)) {
                AppsSection(section, expanded, onSeeMore)
            } else {
                GenericGridSection(section)
            }
            Spacer(Modifier.height(16.dp))
        }

        // Sign Out (Static or from API)
        val signOutItem = sections.flatMap { it.items }.find { it.label == "Sign Out" }
        if (signOutItem != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFFFEBEE), RoundedCornerShape(8.dp))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Sign Out", color = Color.Red, fontWeight = FontWeight.SemiBold)
            }
        }
        
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
fun GenericGridSection(section: MenuSection) {
    if (section.name.isNotEmpty()) {
        Text(
            text = section.name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }

    section.items.chunked(2).forEach { rowItems ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            rowItems.forEach { item ->
                DrawerGridItem(item = item, modifier = Modifier.weight(1f).padding(vertical = 5.dp))
            }
            if (rowItems.size == 1) Spacer(Modifier.weight(1f))
        }
    }
}
