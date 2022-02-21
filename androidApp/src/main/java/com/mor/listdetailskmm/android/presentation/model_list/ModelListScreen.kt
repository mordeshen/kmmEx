package com.mor.listdetailskmm.android.presentation.model_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier


@Composable
fun ModelListScreen(
    onSelectModel: (Int) -> Unit,
){
    LazyColumn {
        items(100){ modelId ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSelectModel(modelId)
                    }
            ){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "ModelId = ${modelId}"
                )
            }
        }
    }
}