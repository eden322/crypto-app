package com.example.firstkotlinapp.data.repository

import com.example.firstkotlinapp.data.remote.CoinPaprikaApi
import com.example.firstkotlinapp.data.remote.dto.CoinDetailDto
import com.example.firstkotlinapp.data.remote.dto.CoinDto
import com.example.firstkotlinapp.domain.repository.CoinRepository
import javax.inject.Inject
class CoinRepositoryImpl @Inject  constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return  api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}