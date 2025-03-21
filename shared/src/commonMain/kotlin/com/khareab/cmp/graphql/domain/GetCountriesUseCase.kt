package com.khareab.cmp.graphql.domain

class GetCountriesUseCase(
    val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries().sortedBy { it.name }
    }
}