package com.khareab.cmp.graphql.ui

import com.khareab.cmp.graphql.domain.DetailedCountry
import com.khareab.cmp.graphql.domain.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val selectedCountry: DetailedCountry? = null,
    val isLoading: Boolean = false
)
