package com.mor.listdetailskmm.android.presentation.model_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.mor.listdetailskmm.domain.model.Model

@Composable
fun ModelList(
    loading: Boolean,
    models: List<Model>,
    onClickModelListItem: (Int) -> Unit
){
    if (loading && models.isEmpty()){
        //loading
    }else if (models.isEmpty()){
        //no items
    }

    LazyColumn {
        println("mpodels ${models}")
        itemsIndexed(
            items = models
        ){index, item ->
            ModelCard(
                model = item,
                onClick = {
                    onClickModelListItem(item.id)
                }
            )
        }
    }
}