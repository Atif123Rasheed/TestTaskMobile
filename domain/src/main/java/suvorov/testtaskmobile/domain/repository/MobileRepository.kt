package suvorov.testtaskmobile.domain.repository

import suvorov.testtaskmobile.domain.model.Cart
import suvorov.testtaskmobile.domain.model.Phone
import suvorov.testtaskmobile.domain.model.Product

interface MobileRepository {
    suspend fun getProducts(): Product
    suspend fun getPhone(): Phone
    suspend fun getCart(): Cart
}