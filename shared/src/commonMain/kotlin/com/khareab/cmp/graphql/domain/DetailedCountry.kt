package com.khareab.cmp.graphql.domain

import com.khareab.cmp.CountryQuery

/**
 * Data class to hold country details
 */
data class DetailedCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
)

/**
 * Extension function to convert [CountryQuery.Country] to [DetailedCountry]
 */
fun CountryQuery.Country.toDetailedCountry() = DetailedCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "",
    currency = currency ?: "",
    languages = languages.map { it.name },
    continent = continent.name
)