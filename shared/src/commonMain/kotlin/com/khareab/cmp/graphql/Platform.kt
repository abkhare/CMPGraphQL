package com.khareab.cmp.graphql

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform