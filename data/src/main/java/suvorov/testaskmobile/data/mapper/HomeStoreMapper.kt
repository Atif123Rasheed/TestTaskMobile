package suvorov.testaskmobile.data.mapper

import suvorov.testaskmobile.data.model.HomeStoreApi
import suvorov.testtaskmobile.domain.model.HomeStore

object HomeStoreMapper:
    BaseMapper<List<HomeStoreApi>, List<HomeStore>> {
    override fun map(item: List<HomeStoreApi>): List<HomeStore> {
        return item.map {
            HomeStore(
                it.id ?: 0,
                it.isNew,
                it.title ?: "",
                it.subtitle ?: "",
                it.picture ?: "",
                it.isBuy
            )
        }
    }
}