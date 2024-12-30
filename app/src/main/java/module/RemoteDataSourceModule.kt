package com.kim.Dormitorymanager.module

import com.kim.Dormitorymanager.datasource.GAuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import remote.datasource.GAuthDataSource
import remote.datasource.likedatasource
import remote.datasource.likedatasourceImpl
import remote.datasource.prfileDataSourceImpl
import remote.datasource.prifileDataSource
import remote.datasource.rankdatasource
import remote.datasource.rankdatasourceImpl
import remote.datasource.subdatasourceImpl
import remote.datasource.wirteDatasource
import remote.datasource.writeDatasouceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    abstract fun provideAuthDatasource(
        gAuthDataSourceImpl: GAuthDataSourceImpl
    ): GAuthDataSource


    @Binds
    abstract fun pprrs(
        likedatasourceImpl: likedatasourceImpl
    ): likedatasource

    @Binds
    abstract fun prrrd(
        prfileDataSourceImpl: prfileDataSourceImpl
    ): prifileDataSource

    @Binds
    abstract fun orrrd(
        rankDataSourceImpl: rankdatasourceImpl
    ): rankdatasource

    @Binds
    abstract fun orrrs(
        subdatasourceImpl: subdatasourceImpl
    ): subdatasourceImpl

    @Binds
    abstract fun ooorr(
        writeDatasouceImpl: writeDatasouceImpl
    ): wirteDatasource
}
