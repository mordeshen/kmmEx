package com.mor.listdetailskmm.android.presentation.model_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mor.listdetailskmm.interactors.model_list.SearchList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ModelListViewModel
    @Inject
    constructor(
        private val savedStateHandle: SavedStateHandle,
        private val searchList: SearchList
    ): ViewModel() {
        init {
            loadModels()
        }

    private fun loadModels() {
        searchList.execute(
            page = 1
        ).onEach { dataState ->
            println("modelListViewModel: ${dataState.isLoading}")

            dataState.data?.let { models ->
                println("modelListViewModel: models: ${models}")
            }

            dataState.message?.let { message ->
                println("modelListViewModel: error: ${message}")
            }
        //in use of .onEach we need to declare the scope that we working on
        }.launchIn(viewModelScope)
    }
}