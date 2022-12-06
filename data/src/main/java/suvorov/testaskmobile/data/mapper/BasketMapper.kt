package suvorov.testaskmobile.data.mapper

import suvorov.testaskmobile.data.model.BasketApi
import suvorov.testtaskmobile.domain.model.Basket

object BasketMapper: BaseMapper<List<BasketApi>, List<Basket>> {
    override fun map(item: List<BasketApi>): List<Basket> {
        return item.map {
            Basket(
                it.id ?: 0,
                it.images ?: "",
                it.price ?: 0,
                it.title ?: ""
            )
        }
    }
}