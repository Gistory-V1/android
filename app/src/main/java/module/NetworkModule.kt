package com.kim.Dormitorymanager.module

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import remote.api.auth.AuthApi
import remote.api.auth.likeApi
import remote.api.auth.profileApi
import remote.api.auth.rankAPi
import remote.api.auth.subApi
import remote.api.auth.wireApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import util.AuthInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("HTTP", message) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshiInstance(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://port-0-gistory-server-v1-m47qofx19aae55ab.sel4.cloudtype.app/")
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthAPi(retrofit: Retrofit): AuthApi{
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun providelikeApi(retrofit: Retrofit): likeApi{
        return retrofit.create(likeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideprofileApi(retrofit: Retrofit): profileApi{
        return retrofit.create(profileApi::class.java)
    }

    @Provides
    @Singleton
    fun provideprofilrankApi(retrofit: Retrofit): rankAPi{
        return retrofit.create(rankAPi::class.java)
    }

    @Provides
    @Singleton
    fun providesubApi(retrofit: Retrofit): subApi{
        return retrofit.create(subApi::class.java)
    }


    @Provides
    @Singleton
    fun providewitrApi(retrofit: Retrofit): wireApi{
        return retrofit.create(wireApi::class.java)
    }





}