package com.seif.ktorzamalekplayersapp.data.remote

import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.data.remote.service.PlayersApi
import com.seif.ktorzamalekplayersapp.util.Resource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val playersApi: PlayersApi
) {
    suspend fun fetchRandomPlayer(): Response<Resource<Player>> {
        return playersApi.fetchRandomPlayer()
    }
}