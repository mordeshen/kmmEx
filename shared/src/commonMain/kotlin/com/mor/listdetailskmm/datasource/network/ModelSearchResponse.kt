package com.mor.listdetailskmm.datasource.network

import com.mor.listdetailskmm.domain.model.Model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModelSearchResponse(
    @SerialName("results") val results : List<ModelDto>,
    @SerialName("info") val info : Info
    )
