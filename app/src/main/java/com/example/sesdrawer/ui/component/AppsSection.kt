package com.example.sesdrawer.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.example.sesdrawer.data.model.MenuSection

@Composable
fun AppsSection(
    section: MenuSection,
    expanded: Boolean,
    onSeeMore: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = section.name ?: "Apps",
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        val allItems = section.items ?: emptyList()
        val displayItems = if (expanded) allItems else allItems.take(4)

        // 2-Column Grid
        displayItems.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rowItems.forEach { item ->
                    DrawerGridItem(
                        item = item,
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 5.dp)
                    )
                }
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }

        if (allItems.size > 4) {
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .background(Color(0xFFE9EBEE), RoundedCornerShape(8.dp))
                    .clickable { onSeeMore() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (expanded) "Show Less" else "See More",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}
