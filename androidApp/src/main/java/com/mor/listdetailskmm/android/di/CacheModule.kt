package com.mor.listdetailskmm.android.di

import android.content.Context
import com.mor.listdetailskmm.BaseApplication
import com.mor.listdetailskmm.datasource.cache.*
import com.mor.listdetailskmm.util.DatetimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideModelDb(context: BaseApplication):ModelDb{
        return ModelDbFactory(driverFactory = DriverFactory(context)).createDb()
    }

    @Singleton
    @Provides
    fun provideModelCache(
        modelDb:ModelDb
    ):ModelCache{
        return ModelCacheImpl(
            modelDb = modelDb,
            datetimeUtil = DatetimeUtil()
        )
    }

}






