package com.khareab.cmp.graphql.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
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
    val cardColors = if (index % 2 == 0) {
        listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB))
    } else {
        listOf(Color(0xFFDCEDC8), Color(0xFFC8E6C9))
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
            .clickable { onItemClick.invoke() },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = Color.Transparent,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(cardColors),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Country emoji
            Text(
                text = country.emoji,
                fontSize = 30.sp,
                modifier = Modifier.padding(end = 16.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = country.name,
                    fontSize = 18.sp
                )
                Text(text = country.capital, fontSize = 14.sp)
            }
        }
    }
}

