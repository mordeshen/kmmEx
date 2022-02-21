package com.mor.listdetailskmm.android.presentation.model_details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.mor.listdetailskmm.domain.model.Model

@Composable
fun ModelDetailsScreen (
    model:Model?,
){
    if (model == null){
        Text(text = "Unable to get the details of this model...")
    }else{
        Column {
            Text(text = "ModelDetailsScreen: ${model.name}")
        }
    }
}