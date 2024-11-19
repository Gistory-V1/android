package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import repository.AuthRepository
import repoistory.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providerAuthRepository(
        authrepoistoryimpl: AuthRepositoryImpl
    ):AuthRepository
}