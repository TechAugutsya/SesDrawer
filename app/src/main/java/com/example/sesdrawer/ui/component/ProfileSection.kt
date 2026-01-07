package com.example.sesdrawer.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.sesdrawer.data.model.User

@Composable
fun ProfileSection(user: User?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = user?.photo,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.width(12.dp))

        Text(
            text = user?.displayname ?: "Guest User",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "Edit Profile",
            color = Color(0xFF4285F4),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
