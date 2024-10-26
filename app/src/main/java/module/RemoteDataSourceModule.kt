package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import remote.datasource.Gauthdatasourceimpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun providAuthDatasource(

        gauthdatasourceimpi: Gauthdatasourceimpl
    ): Gauthdatasourceimpl
}
