package com.mor.listdetailskmm.datasource.network

import io.ktor.client.*
//import io.ktor.client.engine.ios.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

actual class KtorClientFactory{
    actual fun build(): HttpClient{
        return HttpClient {
            install(JsonFeature){
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true
                    }
                )
            }
        }
    }
}