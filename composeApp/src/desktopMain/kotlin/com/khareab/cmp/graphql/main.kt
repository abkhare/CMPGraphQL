package com.khareab.cmp.graphql

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

/**
 * Desktop application main.
 */
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CmpGraphql",
    ) {
        App()
    }
}