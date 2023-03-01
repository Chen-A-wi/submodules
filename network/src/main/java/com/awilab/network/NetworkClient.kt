package com.awilab.network

import com.squareup.moshi.Moshi
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun createOkHttpClient(): OkHttpClient {
	return OkHttpClient.Builder()
		.retryOnConnectionFailure(true)
		.addNetworkInterceptor(LoggerInterceptor())
		.connectTimeout(60L, TimeUnit.SECONDS)
		.readTimeout(60L, TimeUnit.SECONDS)
		.connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
		.build()
}

inline fun <reified T> createService(
	okHttpClient: OkHttpClient,
	moshi: Moshi,
	serverUrl: String
): T {
	val retrofit = Retrofit.Builder()
		.baseUrl(serverUrl) // 設定請求URL
		.client(okHttpClient) // 設定OkHttp攔截器
		.addConverterFactory(MoshiConverterFactory.create(moshi)) // 設定解析工具
		.build()

	return retrofit.create(T::class.java)
}