package com.awilab.network.di

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.awilab.network.MoshiArrayListJsonAdapter
import com.awilab.network.createOkHttpClient
import com.squareup.moshi.Moshi
import org.koin.dsl.module

val networkModule = module {
	single {
		Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.add(MoshiArrayListJsonAdapter.FACTORY)
			.build()
	}
	single { createOkHttpClient() }
}