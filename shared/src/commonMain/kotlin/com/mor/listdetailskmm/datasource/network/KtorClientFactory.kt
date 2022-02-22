package com.mor.listdetailskmm.datasource.network

import android.util.Log
import com.mor.listdetailskmm.domain.model.Model
import io.ktor.client.*

private const val TAG = "KtorClientFactory"
expect class KtorClientFactory (){
    fun build(): HttpClient
}

fun ModelDto.toModel(): Model {
    return Model(
        id = id,
        name =  name,
        status  = status,
        species = species,
        type =  type,
        gender  = gender,
        origin  = origin!!,
        location = location!!,
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun List<ModelDto>.toModelList(): List<Model> {
    Log.e(TAG, "toModelList: $this", )
    return map{it.toModel()}
}