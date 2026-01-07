package com.example.sesdrawer.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sesdrawer.data.model.MenuItem
import com.example.sesdrawer.data.model.MenuSection
import com.example.sesdrawer.data.model.User
import com.example.sesdrawer.data.repository.NavigationRepository
import kotlinx.coroutines.launch

class DrawerViewModel(
    private val repository: NavigationRepository = NavigationRepository()
) : ViewModel() {

    var uiState by mutableStateOf<DrawerUiState>(DrawerUiState.Loading)
        private set

    var isAppsExpanded by mutableStateOf(false)
        private set

    init {
        fetchDrawerData()
    }

    fun fetchDrawerData() {
        uiState = DrawerUiState.Loading
        viewModelScope.launch {
            try {
                val response = repository.getNavigationData()
                Log.d("DrawerViewModel", "API Response: $response")

                val result = response.result
                if (result != null) {
                    val user = User(
                        displayname = result.title ?: "Guest",
                        photo = result.userPhoto ?: ""
                    )
                    
                    val sections = parseMenus(result.menus ?: emptyList())
                    
                    uiState = DrawerUiState.Success(user, sections)
                } else {
                    uiState = DrawerUiState.Error("Invalid API response")
                }
            } catch (e: Exception) {
                Log.e("DrawerViewModel", "Error", e)
                uiState = DrawerUiState.Error("Error: ${e.localizedMessage}")
            }
        }
    }

    private fun parseMenus(items: List<MenuItem>): List<MenuSection> {
        val sections = mutableListOf<MenuSection>()
        var currentSectionName = ""
        var currentItems = mutableListOf<MenuItem>()

        items.forEach { item ->
            if (item.type == 0) {
                // If we were already building a section, save it
                if (currentItems.isNotEmpty() || currentSectionName.isNotEmpty()) {
                    sections.add(MenuSection(currentSectionName, currentItems))
                }
                // Start a new section
                currentSectionName = item.label ?: ""
                currentItems = mutableListOf()
            } else {
                currentItems.add(item)
            }
        }
        
        // Add the last section
        if (currentItems.isNotEmpty() || currentSectionName.isNotEmpty()) {
            sections.add(MenuSection(currentSectionName, currentItems))
        }

        return sections
    }

    fun onSeeMoreClicked() {
        isAppsExpanded = !isAppsExpanded
    }
}
