package com.mor.listdetailskmm.datasource.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info
    (
    @SerialName("count") val count : Int? = 0,
    @SerialName("pages") val pages : Int? = 0,
    @SerialName("next") val next : String? = "",
    @SerialName("prev") val prev : String? = ""
    )
