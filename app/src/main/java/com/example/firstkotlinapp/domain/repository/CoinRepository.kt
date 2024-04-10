package com.example.firstkotlinapp.domain.repository

import com.example.firstkotlinapp.data.remote.dto.CoinDetailDto
import com.example.firstkotlinapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}