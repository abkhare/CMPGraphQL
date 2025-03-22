package com.khareab.cmp.graphql.domain

/**
 * Interface to hold service of country client
 */
interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}