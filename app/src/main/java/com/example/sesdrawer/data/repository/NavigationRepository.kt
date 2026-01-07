package com.example.sesdrawer.data.repository

import com.example.sesdrawer.data.model.NavigationResponse
import com.example.sesdrawer.data.remote.RetrofitClient

class NavigationRepository {

    suspend fun getNavigationData(): NavigationResponse {
        return RetrofitClient.api.getNavigation(
            token = "B179086bb56c32731633335762"
        )
    }
}
