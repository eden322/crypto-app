package com.example.firstkotlinapp.presentation.theme.coin_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.firstkotlinapp.common.Resource
import com.example.firstkotlinapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val  _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(

                    )
                }
                is Resource.Loading -> {

                }
            }
        }
    }
}