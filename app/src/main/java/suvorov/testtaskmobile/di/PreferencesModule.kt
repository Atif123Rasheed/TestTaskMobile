package suvorov.testtaskmobile.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val preferencesModule = module {
    single {
        providePreferences(androidApplication())
    }
}

fun providePreferences(application: Application): SharedPreferences {
    return application.getSharedPreferences("Mobile preferences", Context.MODE_PRIVATE)
}