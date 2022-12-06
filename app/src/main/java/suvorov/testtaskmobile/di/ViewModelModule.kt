package suvorov.testtaskmobile.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import suvorov.testtaskmobile.ui.cart.CartViewModel
import suvorov.testtaskmobile.ui.detail.DetailViewModel
import suvorov.testtaskmobile.ui.home.HomeViewModel
import suvorov.testtaskmobile.ui.base.SharedViewModel

val viewModelModule = module {
    viewModel {
        SharedViewModel()
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        DetailViewModel(get())
    }
    viewModel {
        CartViewModel(get())
    }
}