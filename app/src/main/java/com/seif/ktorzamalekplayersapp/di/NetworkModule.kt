package com.seif.ktorzamalekplayersapp.di

import com.seif.ktorzamalekplayersapp.data.remote.RemoteDataSource
import com.seif.ktorzamalekplayersapp.data.remote.service.PlayersApi
import com.seif.ktorzamalekplayersapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApi() =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlayersApi::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(playersApi: PlayersApi): RemoteDataSource {
        return RemoteDataSource(playersApi)
    }
}