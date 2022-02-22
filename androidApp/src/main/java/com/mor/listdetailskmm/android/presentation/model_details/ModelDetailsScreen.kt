package com.mor.listdetailskmm.android.presentation.model_details

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.mor.listdetailskmm.android.presentation.components.ModelImage
import com.mor.listdetailskmm.android.presentation.model_list.components.ModelCard
import com.mor.listdetailskmm.android.presentation.theme.AppTheme
import com.mor.listdetailskmm.domain.model.Model

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun ModelDetailsScreen (
    model:Model?,
){
    AppTheme(displayProgressBar = false) {
        if (model == null){
            Text(text = "Unable to get the details of this model...")
        }else{
            ModelCard(model = model, onClick = { /*TODO*/ })
        }
    }

}