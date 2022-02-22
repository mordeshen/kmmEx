package com.mor.listdetailskmm.datasource.network

import com.mor.listdetailskmm.domain.model.Model

interface ModelService {
    suspend fun search(
        page: Int,
        query: String,
    ): List<Model>

    suspend fun get(
        id: Int
    ): Model
}