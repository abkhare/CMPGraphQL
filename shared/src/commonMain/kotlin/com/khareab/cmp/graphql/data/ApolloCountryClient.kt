package com.khareab.cmp.graphql.data

import com.apollographql.apollo.ApolloClient
import com.khareab.cmp.CountriesQuery
import com.khareab.cmp.CountryQuery
import com.khareab.cmp.graphql.domain.CountryClient
import com.khareab.cmp.graphql.domain.DetailedCountry
import com.khareab.cmp.graphql.domain.SimpleCountry
import com.khareab.cmp.graphql.domain.toDetailedCountry
import com.khareab.cmp.graphql.domain.toSimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}