package suvorov.testaskmobile.data.mapper

import suvorov.testaskmobile.data.model.CartApi
import suvorov.testtaskmobile.domain.model.Cart

object CartMapper: BaseMapper<CartApi, Cart> {
    override fun map(item: CartApi): Cart {
        return Cart(
            BasketMapper.map(item.basket),
            item.delivery ?: "",
            item.id ?: "",
            item.total ?: 0
        )
    }
}