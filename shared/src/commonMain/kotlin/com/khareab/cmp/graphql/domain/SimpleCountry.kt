package com.khareab.cmp.graphql.domain

import com.khareab.cmp.CountriesQuery

data class SimpleCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String
)


fun CountriesQuery.Country.toSimpleCountry() = SimpleCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No Capital"
)