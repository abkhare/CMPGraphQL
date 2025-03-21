package com.khareab.cmp.graphql

import android.app.Application
import com.khareab.cmp.graphql.di.appModule
import com.khareab.cmp.graphql.di.sharedModule
import org.koin.core.context.startKoin

class CmpGraphqlApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + sharedModule)
        }
    }
}