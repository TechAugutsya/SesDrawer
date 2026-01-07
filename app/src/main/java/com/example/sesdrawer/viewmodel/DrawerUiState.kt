package com.example.sesdrawer.viewmodel

import com.example.sesdrawer.data.model.MenuSection
import com.example.sesdrawer.data.model.User

sealed class DrawerUiState {
    object Loading : DrawerUiState()
    data class Success(val user: User, val sections: List<MenuSection>) : DrawerUiState()
    data class Error(val message: String) : DrawerUiState()
}
