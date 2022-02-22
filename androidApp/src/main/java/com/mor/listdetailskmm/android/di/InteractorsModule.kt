package com.mor.listdetailskmm.android.di

import com.mor.listdetailskmm.datasource.cache.ModelCache
import com.mor.listdetailskmm.datasource.network.ModelService
import com.mor.listdetailskmm.interactors.model_details.GetDetails
import com.mor.listdetailskmm.interactors.model_list.SearchList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideSearchModels(
        modelService: ModelService,
        modelCache: ModelCache
    ): SearchList {
        return SearchList(modelService = modelService, modelCache = modelCache)
    }

    @Singleton
    @Provides
    fun provideGetDetails(
        modelCache: ModelCache
    ):GetDetails{
        return GetDetails(modelCache = modelCache)
    }
}







