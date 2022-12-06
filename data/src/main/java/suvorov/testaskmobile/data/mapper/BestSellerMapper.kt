package suvorov.testaskmobile.data.mapper

import suvorov.testaskmobile.data.model.BestSellerApi
import suvorov.testtaskmobile.domain.model.BestSeller

object BestSellerMapper:
    BaseMapper<List<BestSellerApi>, List<BestSeller>> {
    override fun map(item: List<BestSellerApi>): List<BestSeller> {
        return item.map {
            BestSeller(
                it.id ?: 0,
                it.isFavorites,
                it.title ?: "",
                it.priceWithoutDiscount ?: 0,
                it.discountPrice ?: 0,
                it.picture ?: ""
            )
        }
    }
}