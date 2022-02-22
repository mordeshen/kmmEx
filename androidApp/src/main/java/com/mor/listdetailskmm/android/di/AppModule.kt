package com.mor.listdetailskmm.android.di

import android.content.Context
import com.mor.listdetailskmm.BaseApplication
import com.mor.listdetailskmm.util.DatetimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideDateUtil(): DatetimeUtil {
        return DatetimeUtil()
    }
}