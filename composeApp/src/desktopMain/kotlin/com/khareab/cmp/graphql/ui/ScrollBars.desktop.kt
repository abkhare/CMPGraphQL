package com.khareab.cmp.graphql.ui

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Actual function to enable scroll for desktop application.
 */
@Composable
actual fun GetScrollBars() {
    val stateVertical = rememberScrollState(0)
    VerticalScrollbar(
        modifier = Modifier.fillMaxHeight(),
        adapter = rememberScrollbarAdapter(stateVertical)
    )
}