package com.khareab.cmp.graphql.domain

/**
 * Usecase class to get list of countries from server
 */
class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries().sortedBy { it.name }
    }
}