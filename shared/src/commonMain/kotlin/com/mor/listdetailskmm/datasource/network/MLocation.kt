package com.mor.listdetailskmm.datasource.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MLocation (
    @SerialName("name") val name : String ="",
    @SerialName("url") val url : String =""
        )