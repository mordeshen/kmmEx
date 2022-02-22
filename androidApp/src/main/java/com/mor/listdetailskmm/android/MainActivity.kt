package com.mor.listdetailskmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.mor.listdetailskmm.android.presentation.navigation.Navigation
import com.mor.listdetailskmm.datasource.network.KtorClientFactory
import com.mor.listdetailskmm.datasource.network.ModelDto
import com.mor.listdetailskmm.datasource.network.ModelSearchResponse
import com.mor.listdetailskmm.datasource.network.toModel
import com.mor.listdetailskmm.datasource.network.ModelServiceImpl

import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlin.text.get

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent{
            Navigation()
        }
    }
}
