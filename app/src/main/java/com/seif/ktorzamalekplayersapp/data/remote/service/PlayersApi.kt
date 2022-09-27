package com.seif.ktorzamalekplayersapp.data.remote.service

import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.util.Resource
import retrofit2.Response
import retrofit2.http.GET

interface PlayersApi {
    @GET("randomplayer")
    suspend fun fetchRandomPlayer(): Response<Resource<Player>>
}