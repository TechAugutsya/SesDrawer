package com.example.sesdrawer.data.model

import com.google.gson.annotations.SerializedName

data class NavigationResponse(
    @SerializedName("result")
    val result: ResultData? = null,
    @SerializedName("session_id")
    val sessionId: String? = null
)

data class ResultData(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("user_photo")
    val userPhoto: String? = null,
    @SerializedName("menus")
    val menus: List<MenuItem>? = null
)

data class MenuItem(
    @SerializedName("type")
    val type: Int? = null, // 0 for header, 1 for item
    @SerializedName("label")
    val label: String? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("module")
    val module: String? = null
)

// Internal UI model to represent sections
data class MenuSection(
    val name: String,
    val items: List<MenuItem>
)

data class User(
    val displayname: String,
    val photo: String
)
