package com.seif.ktorzamalekplayersapp.di

import com.seif.ktorzamalekplayersapp.PlayerApplication
import com.seif.ktorzamalekplayersapp.data.remote.RemoteDataSource
import com.seif.ktorzamalekplayersapp.data.remote.service.PlayersApi
import com.seif.ktorzamalekplayersapp.data.repository.RepositoryImp
import com.seif.ktorzamalekplayersapp.domain.repository.Repository
import com.seif.ktorzamalekplayersapp.domain.usecase.GetRandomPlayerUseCase
import com.seif.ktorzamalekplayersapp.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetRandomPlayerUseCase(repository: Repository): GetRandomPlayerUseCase{
        return GetRandomPlayerUseCase(repository)
    }
}