package suvorov.testaskmobile.data.mapper

import suvorov.testaskmobile.data.model.PhoneApi
import suvorov.testtaskmobile.domain.model.Phone

object PhoneMapper: BaseMapper<PhoneApi, Phone> {
    override fun map(item: PhoneApi): Phone {
        return Phone(
            item.cpu ?: "",
            item.camera ?: "",
            item.capacity ?: emptyList(),
            item.color ?: emptyList(),
            item.id ?: "",
            item.images ?: emptyList(),
            item.isFavorites,
            item.price ?: 0,
            item.rating ?: 0.0,
            item.sd ?: "",
            item.ssd ?: "",
            item.title ?: ""
        )
    }
}