package com.mor.listdetailskmm.datasource.cache

import com.mor.listdetailskmm.dataSource.cache.ModelDbQueries
import com.mor.listdetailskmm.datasource.network.ModelServiceImpl.Companion.MODEL_PAGINATION_PAGE_SIZE
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
            origin = model.origin.toString(),
            location = model.location.toString(),
            episode = model.episode.toString(),
            image = model.image,
            url = model.url,
            created = model.created
        )
    }

    override fun insert(models: List<Model>) {
       for (model in models){
           insert(model)
       }
    }

    override fun search(query: String,page: Int): List<Model> {
        return queries.searchModels(
            query = query,
            pageSize = MODEL_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page-1)* MODEL_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toModelList()
    }

    override fun getAll(page: Int): List<Model> {
        return queries.getListOfModels(
            pageSize = MODEL_PAGINATION_PAGE_SIZE.toLong(),
            offset = ((page-1)* MODEL_PAGINATION_PAGE_SIZE).toLong()
        ).executeAsList().toModelList()
    }

    override fun get(modelId: Int): Model? {
        return try {
            queries.getModelById(id = modelId.toLong())
                .executeAsOne().toModel()
        }catch (e : NullPointerException){
            null
        }
    }


}