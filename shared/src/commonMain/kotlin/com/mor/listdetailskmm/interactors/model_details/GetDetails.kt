package com.mor.listdetailskmm.interactors.model_details

import com.mor.listdetailskmm.datasource.cache.ModelCache
import com.mor.listdetailskmm.domain.model.DataState
import com.mor.listdetailskmm.domain.model.Model
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetDetails (
    private val modelCache: ModelCache,
){
    fun execute(
        modelId: Int,
    ): Flow<DataState<Model>> = flow {
        try {
            emit(DataState.loading())

            val model = modelCache.get(modelId)

            emit(DataState.data(message = null, data = model))

        }catch (e: Exception){
            emit(DataState.error<Model>(message = e.message ?: "Unknown Error"))
        }
    }

}
