package com.seif.ktorzamalekplayersapp.presentation.home

import com.seif.ktorzamalekplayersapp.data.remote.dto.Player

data class PlayerState(
    val player:Player? = null,
    val isLoading: Boolean = false,
    val error:String?=null
)
