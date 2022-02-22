package com.mor.listdetailskmm.interactors.model_list

import com.mor.listdetailskmm.datasource.cache.ModelCache
import com.mor.listdetailskmm.datasource.network.ModelService
import com.mor.listdetailskmm.domain.model.DataState
import com.mor.listdetailskmm.domain.model.Model
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchList (
    private val modelService: ModelService,
    private val modelCache: ModelCache
        ) {
    fun execute(
        page: Int,
        query: String
    ):Flow<DataState<List<Model>>> = flow {
        //emit
        emit(DataState.loading())
        try{
            val models = modelService.search(
                page = page,
                query = query
            )
            println("SearchList $models")
//            modelCache.insert(models)

            val cacheResult = models
//            val cacheResult = modelCache.getAll(1)
//            val cacheResult = if(query.isBlank()){
//                modelCache.getAll(page = page)
//            }else{
//                modelCache.search(
//                    query = query,
//                    page = page
//                )
//            }
            println("SearchList $cacheResult")


            emit(DataState.data(data = cacheResult))
        }catch (e:Exception){
            emit(DataState.error<List<Model>>(message = e.message?: "Unknown Error"))
        }
    }
}