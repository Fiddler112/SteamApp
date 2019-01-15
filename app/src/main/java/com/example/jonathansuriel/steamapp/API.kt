package com.example.jonathansuriel.steamapp

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "D910FDEA6E2DFE44FEE7CA2B04CD8449"

// http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=D910FDEA6E2DFE44FEE7CA2B04CD8449&steamid=76561198017673882&include_appinfo=1&format=json

interface API {

    @GET
    fun getSteam(
        @Query("steamid") Steamid: Int
    ): Deferred<Steam>

    companion object {
        operator fun invoke(): API {
            val requestInterceptor = Interceptor{ chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)

        }
    }
}