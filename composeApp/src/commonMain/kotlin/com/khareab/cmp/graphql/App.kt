package com.khareab.cmp.graphql

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import cmpgraphql.composeapp.generated.resources.Res
import cmpgraphql.composeapp.generated.resources.compose_multiplatform
import com.khareab.cmp.graphql.di.appModule
import com.khareab.cmp.graphql.di.sharedModule
import com.khareab.cmp.graphql.ui.CountriesScreen
import com.khareab.cmp.graphql.ui.CountriesViewModel
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

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