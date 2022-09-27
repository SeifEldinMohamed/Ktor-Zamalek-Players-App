package com.seif.ktorzamalekplayersapp.di

import com.seif.ktorzamalekplayersapp.data.remote.RemoteDataSource
import com.seif.ktorzamalekplayersapp.data.repository.RepositoryImp
import com.seif.ktorzamalekplayersapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return RepositoryImp(remoteDataSource)
    }
}