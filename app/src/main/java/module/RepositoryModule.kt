package com.kim.Dormitorymanager.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import reopoistory.LikeRepository
import reopoistory.ProfileRepository
import reopoistory.WriteRepository
import reopoistory.rankRepository
import reopoistory.subRepository
import repository.AuthRepository
import repoistory.AuthRepositoryImpl
import repoistory.LikerepositoryImpl
import repoistory.RankRepositoryImpl
import repoistory.SubrepositoryImpl
import repoistory.WriteRepositoryImpl
import repoistory.profileRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providerAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ):AuthRepository

    @Binds
    abstract fun providerProfileRepository(
        profileRepositoryImpl: profileRepositoryImpl
    ): ProfileRepository

    @Binds
    abstract fun prooooooooooooooviderProfileRepository(
        likeRepositoryImpl: LikerepositoryImpl
    ): LikeRepository

    @Binds
    abstract fun proooooooooooooviderProfileRepository(
        rankRepositoryImpl: RankRepositoryImpl
    ): rankRepository

    @Binds
    abstract fun prrooviderProfileRepository(
        subrepositoryImpl: SubrepositoryImpl
    ): subRepository

    @Binds
    abstract fun proo(
        writeRepositoryImpl: WriteRepositoryImpl
    ): WriteRepository



}