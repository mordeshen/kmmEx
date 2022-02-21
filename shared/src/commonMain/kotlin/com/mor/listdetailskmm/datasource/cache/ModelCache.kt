package com.mor.listdetailskmm.datasource.cache

import com.mor.listdetailskmm.domain.model.Model

interface ModelCache {
    fun insert(model: Model)

    fun insert(Models: List<Model>)

    fun search(
//        query: String,
        page: Int): List<Model>

    fun getAll(page: Int): List<Model>

    @Throws(NullPointerException::class)
    fun get(modelId: Int): Model?
}