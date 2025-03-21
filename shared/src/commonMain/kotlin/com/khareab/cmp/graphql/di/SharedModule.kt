package com.khareab.cmp.graphql.di

import com.apollographql.apollo.ApolloClient
import com.khareab.cmp.graphql.domain.CountryClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import com.khareab.cmp.graphql.data.ApolloCountryClient
import com.khareab.cmp.graphql.domain.GetCountriesUseCase
import com.khareab.cmp.graphql.domain.GetCountryUseCase

val sharedModule = module {
    single {
        ApolloClient
            .Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }
    singleOf(::ApolloCountryClient) { bind<CountryClient>() }
    singleOf(::GetCountriesUseCase)
    singleOf(::GetCountryUseCase)
}