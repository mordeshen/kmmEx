package com.mor.listdetailskmm.interactors.model_list

import com.mor.listdetailskmm.datasource.network.ModelService
import com.mor.listdetailskmm.domain.model.DataState
import com.mor.listdetailskmm.domain.model.Model
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchList (
    private val modelService: ModelService,
        ) {
    fun execute(
        page: Int,
//        query: String
    ):Flow<DataState<List<Model>>> = flow {
        //emit
        emit(DataState.loading())
        try{
            val models = modelService.search(
                page = page,
//                query = query
            )
            emit(DataState.data(data = models))
        }catch (e:Exception){
            emit(DataState.error<List<Model>>(message = e.message?: "Unknown Error"))
        }
    }
}