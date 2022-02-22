package com.mor.listdetailskmm.datasource.cache

import com.mor.listdetailskmm.dataSource.cache.Model_Entity
import com.mor.listdetailskmm.datasource.network.MLocation
import com.mor.listdetailskmm.datasource.network.MOrigin
import com.mor.listdetailskmm.domain.model.Model
import com.squareup.sqldelight.db.SqlDriver

class ModelDbFactory(
    private val driverFactory: DriverFactory
) {
    fun createDb(): ModelDb{
        return ModelDb(driverFactory.createDriver())
    }
}

expect class DriverFactory{
    fun createDriver(): SqlDriver
}

fun Model_Entity.toModel(): Model {
    return Model(
        id = id.toInt(),
        name  = name,
        status = status,
        species = species,
        type = type.toString(),
        gender = gender,
        origin = origin.toMOrigin(),
        location = location.toMLocation(),
        episode = episode.toMEpisode(),
        image = image,
        url = url,
        created = created
    )
}

fun List<Model_Entity>.toModelList(): List<Model>{
    return map {it.toModel()}
}

fun String.toMOrigin(): MOrigin {
    val list : ArrayList<String> = ArrayList()
    for (orig in split(",")){
        list.add(orig)
    }
    return MOrigin(
        name = list[0],
        url = list[1]
    )
}

fun String.toMLocation(): MLocation {
    val list : ArrayList<String> = ArrayList()
    for (locate in split(",")){
        list.add(locate)
    }
    return MLocation(
        name = list[0],
        url = list[1]
    )
}

fun String.toMEpisode(): List<String> {
    val list : ArrayList<String> = ArrayList()
    for (episode in split(",")){
        list.add(episode)
    }
    return list
}
