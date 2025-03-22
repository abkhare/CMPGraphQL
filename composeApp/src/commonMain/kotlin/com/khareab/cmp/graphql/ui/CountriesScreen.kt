package com.khareab.cmp.graphql.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khareab.cmp.graphql.domain.SimpleCountry

/**
 * CountriesScreen composable function.
 * @param state The state of the countries screen.
 * @param onSelectedCountry The callback function to be invoked when a country is selected.
 */
@Composable
fun CountriesScreen(
    state: CountriesState,
    onSelectedCountry: (String) -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            // Loading indicator
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            // List of countries
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.countries.size) { index ->
                    // Country Item
                    CountryItem(
                        country = state.countries[index],
                        index = index
                    ) {
                        onSelectedCountry(state.countries[index].code)
                    }
                }
            }
            GetScrollBars()
        }
    }
}

@Composable
fun CountryItem(
    country: SimpleCountry,
    modifier: Modifier = Modifier,
    index: Int = 0,
    onItemClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
            onItemClick.invoke()
        }.background( if (index%2 == 0) Color.LightGray else Color.Cyan),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Country emoji
        Text(
            text = country.emoji,
            fontSize = 30.sp
        )
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            // Country name and capital
            Text(
                text = country.name,
                fontSize = 24.sp
            )
            Text(
                text = country.capital,
                fontSize = 24.sp
            )
        }
    }
}