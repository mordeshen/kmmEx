package com.mor.listdetailskmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
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


const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
//const val BASE_URL = "https://food2fork.ca/api/recipe"
const val BASE_URL = "https://rickandmortyapi.com/api/character"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(IO).launch {
//            val modelService = ModelServiceImpl(
//                httpClient = KtorClientFactory().build(),
//                baseUrl = BASE_URL,
//            )
//            val modelId = 15
//            val model = modelService.get(modelId)
//            println("KtorTest: ${model.name}")
//            println("KtorTest: ${model.species}")
//        }

        setContent{
            Navigation()
        }
    }
}
