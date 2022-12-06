package suvorov.testaskmobile.data.repository

import suvorov.testaskmobile.data.api.ApiService
import suvorov.testaskmobile.data.mapper.CartMapper
import suvorov.testaskmobile.data.mapper.PhoneMapper
import suvorov.testaskmobile.data.mapper.ProductMapper
import suvorov.testtaskmobile.domain.repository.MobileRepository

class MobileRepositoryImpl(private val service: ApiService): MobileRepository {

    override suspend fun getProducts() = ProductMapper.map(service.getProducts())

    override suspend fun getPhone() = PhoneMapper.map(service.getPhone())

    override suspend fun getCart() = CartMapper.map(service.getCart())
}