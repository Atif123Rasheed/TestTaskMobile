package suvorov.testaskmobile.data.mapper

import suvorov.testaskmobile.data.model.ProductApi
import suvorov.testtaskmobile.domain.model.Product

object ProductMapper: BaseMapper<ProductApi, Product> {
    override fun map(item: ProductApi): Product {
        return Product(
            HomeStoreMapper.map(item.homeStore),
            BestSellerMapper.map(item.bestSeller)
        )
    }
}