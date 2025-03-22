package com.khareab.cmp.graphql

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.khareab.cmp.graphql.di.appModule
import com.khareab.cmp.graphql.di.sharedModule
import com.khareab.cmp.graphql.ui.CountriesScreen
import com.khareab.cmp.graphql.ui.CountriesViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

/**
 * Composable function which is the entry point of all platforms.
 */
@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule + sharedModule)
    }) {
        MaterialTheme {
            val viewModel = koinViewModel<CountriesViewModel>()
            val state = viewModel.state.collectAsState()
            CountriesScreen(
                state = state.value,
                onSelectedCountry = {}
            ) { }
        }
    }

}