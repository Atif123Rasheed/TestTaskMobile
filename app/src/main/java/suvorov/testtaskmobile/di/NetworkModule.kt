package suvorov.testtaskmobile.di

import org.koin.dsl.module
import suvorov.testaskmobile.data.api.ApiServiceProvider.provideApiService

val networkModule = module {
    single { provideApiService() }
}