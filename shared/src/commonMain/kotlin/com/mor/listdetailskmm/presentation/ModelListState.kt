package com.mor.listdetailskmm.presentation

import com.mor.listdetailskmm.domain.model.Model

data class ModelListState (
    val isLoading: Boolean = false,
    val page: Int = 1,
    val query: String = "",
    val models: List<Model> = listOf(),

    )