package com.khareab.cmp.graphql.di

import org.koin.core.module.dsl.viewModelOf
import com.khareab.cmp.graphql.ui.CountriesViewModel
import org.koin.dsl.module

/**
 * Koin module for the composeApp.
 */
val appModule = module {
    viewModelOf(::CountriesViewModel)
}