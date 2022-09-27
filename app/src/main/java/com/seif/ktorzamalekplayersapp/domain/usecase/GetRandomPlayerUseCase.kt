package com.seif.ktorzamalekplayersapp.domain.usecase

import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.domain.repository.Repository
import com.seif.ktorzamalekplayersapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetRandomPlayerUseCase @Inject constructor(
    private val repository: Repository
){
    operator fun invoke(): Flow<Resource<Player>> {
        return repository.fetchRandomPlayer()
    }
}