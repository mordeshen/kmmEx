package com.mor.listdetailskmm.domain.model

import com.mor.listdetailskmm.datasource.network.MLocation
import com.mor.listdetailskmm.datasource.network.MOrigin
import kotlinx.serialization.SerialName

data class Model (
        val id : Int,
        val name : String,
        val status : String,
        val species : String,
        val type : String,
        val gender : String,
        val origin : MOrigin,
        val location : MLocation,
        val image : String,
        val episode : List<String>,
        val url : String,
        val created : String
        )