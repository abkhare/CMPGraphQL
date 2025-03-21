package com.khareab.cmp.graphql.domain

class GetCountryUseCase(
    val countryClient: CountryClient
) {
    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}