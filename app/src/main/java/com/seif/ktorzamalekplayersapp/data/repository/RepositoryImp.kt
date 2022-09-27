package com.seif.ktorzamalekplayersapp.data.repository

import com.seif.ktorzamalekplayersapp.data.remote.RemoteDataSource
import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.domain.repository.Repository
import com.seif.ktorzamalekplayersapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    ) : Repository {
    override suspend fun fetchRandomPlayer(): Response<Resource<Player>> {
        return remoteDataSource.fetchRandomPlayer()
    }

}