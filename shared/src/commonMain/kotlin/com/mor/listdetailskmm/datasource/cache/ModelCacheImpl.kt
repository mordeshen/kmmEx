package com.mor.listdetailskmm.datasource.cache

import com.mor.listdetailskmm.dataSource.cache.ModelDbQueries
import com.mor.listdetailskmm.domain.model.Model
import com.mor.listdetailskmm.util.DatetimeUtil

class ModelCacheImpl (
           val modelDb:ModelDb,
           private val datetimeUtil: DatetimeUtil
        ):ModelCache{
            private var queries:ModelDbQueries = modelDb.modelDbQueries
    override fun insert(model: Model) {
        queries.insertModel(
            id = model.id.toLong(),
            name= model.name,
            status = model.status,
            species = model.species,
            type = model.type.toLong(),
            gender = model.gender,
            image = model.image,
            url = model.url,
            created = model.created
        )
    }

    override fun insert(Models: List<Model>) {
        TODO("Not yet implemented")
    }

    override fun search(page: Int): List<Model> {
        TODO("Not yet implemented")
    }

    override fun getAll(page: Int): List<Model> {
        TODO("Not yet implemented")
    }

    override fun get(modelId: Int): Model? {
        TODO("Not yet implemented")
    }


}