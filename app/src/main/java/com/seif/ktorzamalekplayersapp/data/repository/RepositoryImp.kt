package com.seif.ktorzamalekplayersapp.data.repository

import com.seif.ktorzamalekplayersapp.data.remote.RemoteDataSource
import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.domain.repository.Repository
import com.seif.ktorzamalekplayersapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    ) : Repository {
    override fun fetchRandomPlayer(): Flow<Resource<Player>> = flow {
        emit(Resource.Loading())
        try {
            val response: Player = remoteDataSource.fetchRandomPlayer()
            emit(Resource.Success(response))
        }
        catch (e:Exception) {
            emit(Resource.Error(e.message))
        }
    }

}