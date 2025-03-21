package com.khareab.cmp.graphql.di

import org.koin.core.context.startKoin

/** Koin initialization for ios app */
fun initKoin() {
    startKoin { modules(appModule + sharedModule) }
}