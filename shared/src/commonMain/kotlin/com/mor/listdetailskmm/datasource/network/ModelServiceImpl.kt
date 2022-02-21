package com.mor.listdetailskmm.datasource.network

import com.mor.listdetailskmm.domain.model.Model
import io.ktor.client.*
import io.ktor.client.request.*

class ModelServiceImpl (
    private val httpClient: HttpClient,
    private val baseUrl: String,
    ):ModelService{
    override suspend fun search(page: Int): List<Model> {
        return httpClient.get<ModelSearchResponse>{
            url("$baseUrl?page=$page")
        }.results.toModelList()
    }

    override suspend fun get(id: Int): Model {
        return httpClient.get<ModelDto>{
            url("$baseUrl/$id")
        }.toModel()
    }

    companion object{
        const val BASE_URL = "https://rickandmortyapi.com/api/character"
    }
}