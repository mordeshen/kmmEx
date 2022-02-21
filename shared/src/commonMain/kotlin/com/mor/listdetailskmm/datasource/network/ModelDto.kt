package com.mor.listdetailskmm.datasource.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModelDto (

        @SerialName("id") val id : Int = 0,

        @SerialName("name")
        val name : String = "",

        @SerialName("status")
        val status : String = "",

        @SerialName("species")
        val species : String = "",

        @SerialName("type")
        val type : String = "",

        @SerialName("gender")
        val gender : String = "",

        @SerialName("origin")
        val origin : MOrigin? = null,

        @SerialName("location")
        val location : MLocation? = null,

        @SerialName("image")
        val image : String = "",

        @SerialName("episode")
        val episode : List<String> = listOf(),

        @SerialName("url")
        val url : String = "",

        @SerialName("created")
        val created : String = ""

        )
