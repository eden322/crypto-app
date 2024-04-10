package com.example.firstkotlinapp.presentation.theme.coin_list

import com.example.firstkotlinapp.common.Resource
import com.example.firstkotlinapp.domain.model.Coin

class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
    ) {
}