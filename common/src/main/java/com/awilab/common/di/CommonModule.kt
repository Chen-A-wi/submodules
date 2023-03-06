package com.awilab.common.di

import com.awilab.common.utils.DispatcherProvider
import com.awilab.common.utils.DispatcherProviderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dispatcherModule = module {
    singleOf(::DispatcherProviderImpl) bind DispatcherProvider::class
}