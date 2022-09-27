package com.seif.ktorzamalekplayersapp.domain.repository

import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
     fun fetchRandomPlayer(): Flow<Resource<Player>>
}