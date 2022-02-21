package com.mor.listdetailskmm.android.di

import com.mor.listdetailskmm.datasource.network.KtorClientFactory
import com.mor.listdetailskmm.datasource.network.ModelService
import com.mor.listdetailskmm.datasource.network.ModelServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{


    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient{
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideModelService(
        httpClient: HttpClient,
    ):ModelService{
        return ModelServiceImpl(
            httpClient = httpClient,
            baseUrl = ModelServiceImpl.BASE_URL
        )
    }
}






