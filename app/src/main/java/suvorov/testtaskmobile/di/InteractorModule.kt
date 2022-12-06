package suvorov.testtaskmobile.di

import org.koin.dsl.module
import suvorov.testtaskmobile.domain.interactor.MobileInteractor
import suvorov.testtaskmobile.domain.interactor.MobileInteractorImpl

val interactorModule = module {
    factory<MobileInteractor> {
        MobileInteractorImpl(get())
    }
}