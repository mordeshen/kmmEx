package com.mor.listdetailskmm.android.presentation.model_list

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mor.listdetailskmm.domain.model.Model
import com.mor.listdetailskmm.interactors.model_list.SearchList
import com.mor.listdetailskmm.presentation.ModelListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
private const val TAG = "ModelListViewModel"

@HiltViewModel
class ModelListViewModel

    @Inject
    constructor(
        private val savedStateHandle: SavedStateHandle,
        private val searchList: SearchList
    ): ViewModel() {
        val state: MutableState<ModelListState> = mutableStateOf(ModelListState())

        init {
            loadModels()
        }

    private fun loadModels() {
        searchList.execute(
            page = state.value.page,
            query = state.value.query
        ).onEach { dataState ->
            state.value = state.value.copy(isLoading = dataState.isLoading)

            Log.e(TAG, "loadModels: state $state" )

            dataState.data?.let { models ->
                Log.e(TAG, "loadModels: $models" )
                appendModels(models = models)
            }

            dataState.message?.let { message ->
                println("modelListViewModel: error: ${message}")
            }
        //in use of .onEach we need to declare the scope that we working on
        }.launchIn(viewModelScope)
    }

    private fun appendModels(models: List<Model>){
        val curr = ArrayList(state.value.models)
        Log.e(TAG, "appendModels1: $curr", )
        curr.addAll(models)
        Log.e(TAG, "appendModels2: $curr", )
        state.value = state.value.copy(models = curr)
        Log.e(TAG, "appendModels3: ${state.value.models}", )

    }
}