package com.seif.ktorzamalekplayersapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seif.ktorzamalekplayersapp.data.remote.dto.Player
import com.seif.ktorzamalekplayersapp.domain.usecase.GetRandomPlayerUseCase
import com.seif.ktorzamalekplayersapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRandomPlayerUseCase: GetRandomPlayerUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PlayerState())
    val state: State<PlayerState> = _state

    init {
        getRandomRabbit()
    }
    fun getRandomRabbit() {
        viewModelScope.launch(Dispatchers.IO) {
            getRandomPlayerUseCase().onEach { response ->
                when (response) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            isLoading = false,
                            error = response.message.toString()
                        )
                    }
                    is Resource.Success -> {
                            _state.value = state.value.copy(
                                player = response.data,
                                isLoading = false
                            )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

}