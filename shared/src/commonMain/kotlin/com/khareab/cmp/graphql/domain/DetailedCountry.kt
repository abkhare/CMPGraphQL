package com.khareab.cmp.graphql.domain

import com.khareab.cmp.CountryQuery

data class DetailedCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
)

fun CountryQuery.Country.toDetailedCountry() = DetailedCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "",
    currency = currency ?: "",
    languages = languages.map { it.name },
    continent = continent.name
)