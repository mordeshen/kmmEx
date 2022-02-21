package com.mor.listdetailskmm.android.presentation.model_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mor.listdetailskmm.android.di.Dummy
import com.mor.listdetailskmm.datasource.network.ModelService
import com.mor.listdetailskmm.domain.model.Model
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ModelDetailsViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val modelService: ModelService
):ViewModel() {
    val model : MutableState<Model?> = mutableStateOf(null)

    init {
        try {
            savedStateHandle.get<Int>("modelId")?.let { modelId ->
                viewModelScope.launch {
                    model.value = modelService.get(modelId)
                    println("Ktor Test: ${model.value?.name}")
                    println("Ktor Test: ${model.value?.species}")
                    println("Ktor Test: ${model.value?.origin.toString()}")
                }
            }

        }catch (e:Exception){
            //will throw some exception. no need to do something, b/c it is a composable that saying "unable to get the details of this model..."
        }
    }

}
