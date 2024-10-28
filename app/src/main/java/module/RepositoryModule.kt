package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import reopoistory.Authrepoistory
import repoistory.Authrepoistoryimpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providerAuthRepository(
        authrepoistoryimpl: Authrepoistoryimpl
    ):Authrepoistory
}