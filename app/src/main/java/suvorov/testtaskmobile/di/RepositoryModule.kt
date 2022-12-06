package suvorov.testtaskmobile.di

import org.koin.dsl.module
import suvorov.testaskmobile.data.repository.MobileRepositoryImpl
import suvorov.testtaskmobile.domain.repository.MobileRepository

val repositoryModule = module {
    factory<MobileRepository> {
        MobileRepositoryImpl(get())
    }
}