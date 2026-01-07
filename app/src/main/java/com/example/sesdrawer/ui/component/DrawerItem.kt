package com.example.sesdrawer.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sesdrawer.data.model.MenuItem

@Composable
fun DrawerGridItem(item: MenuItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            model = item.icon,
            contentDescription = item.label,
            modifier = Modifier
                .size(24.dp)
                .background(Color.Transparent)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = item.label ?: "",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color(0xFF333333),
            maxLines = 1
        )
    }
}
