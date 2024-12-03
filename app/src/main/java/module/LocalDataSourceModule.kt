package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import local.datasource.LocalDataSource
import local.datasource.LocalDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    abstract fun provideLocalAuthDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource
}