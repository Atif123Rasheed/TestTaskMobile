package suvorov.testtaskmobile.domain.interactor

import suvorov.testtaskmobile.domain.model.Cart
import suvorov.testtaskmobile.domain.model.Phone
import suvorov.testtaskmobile.domain.model.Product

interface MobileInteractor {
    suspend fun getProducts(): Product
    suspend fun getPhone(): Phone
    suspend fun getCart(): Cart
}