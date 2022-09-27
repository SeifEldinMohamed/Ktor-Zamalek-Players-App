package com.seif.ktorzamalekplayersapp.domain.repository

import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.util.Resource
import retrofit2.Response

interface Repository {
    suspend fun fetchRandomPlayer(): Response<Resource<Player>>
}