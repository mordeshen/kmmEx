package com.mor.listdetailskmm.android.presentation.model_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.mor.listdetailskmm.android.presentation.model_list.components.ModelCard
import com.mor.listdetailskmm.android.presentation.model_list.components.ModelList
import com.mor.listdetailskmm.android.presentation.theme.AppTheme
import com.mor.listdetailskmm.presentation.ModelListState


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun ModelListScreen(
    onClickModelListItem: (Int) -> Unit,
    state: ModelListState
){
    AppTheme(displayProgressBar = false) {
        ModelList(loading = state.isLoading, models = state.models, onClickModelListItem = onClickModelListItem)
    }

}