package com.example.firstkotlinapp.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.firstkotlinapp.common.Resource
import com.example.firstkotlinapp.data.remote.dto.toCoin
import com.example.firstkotlinapp.data.remote.dto.toCoinDetail
import com.example.firstkotlinapp.domain.model.Coin
import com.example.firstkotlinapp.domain.model.CoinDetail
import com.example.firstkotlinapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (_: IOException) {
            emit(Resource.Error("check your internet connection"))
        }
    }
}