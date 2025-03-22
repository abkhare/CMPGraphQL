package com.khareab.cmp.graphql.domain

import com.khareab.cmp.CountriesQuery

/**
 * Data class to hold simple country data
 */
data class SimpleCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String
)

/**
 * Extension function to convert [CountriesQuery.Country] to [SimpleCountry]
 */
fun CountriesQuery.Country.toSimpleCountry() = SimpleCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No Capital"
)