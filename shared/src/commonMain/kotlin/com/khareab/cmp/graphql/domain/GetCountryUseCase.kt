package com.khareab.cmp.graphql.domain

/**
 * Usecase class to get country deatils from server
 */
class GetCountryUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}