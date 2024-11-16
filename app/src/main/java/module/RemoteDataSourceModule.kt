package com.kim.Dormitorymanager.module

import com.kim.Dormitorymanager.datasource.GAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideAuthDatasource(

        gauthdatasourceimpl: GAuthDataSourceImpl
    ): GAuthDataSourceImpl
}
