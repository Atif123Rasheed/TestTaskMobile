package suvorov.testtaskmobile.domain.interactor

import suvorov.testtaskmobile.domain.repository.MobileRepository

class MobileInteractorImpl(private val repository: MobileRepository): MobileInteractor {

    override suspend fun getProducts() = repository.getProducts()

    override suspend fun getPhone() = repository.getPhone()

    override suspend fun getCart() = repository.getCart()
}