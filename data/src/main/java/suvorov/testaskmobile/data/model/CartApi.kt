package suvorov.testaskmobile.data.model

data class CartApi(
    val basket: List<BasketApi>,
    val delivery: String?,
    val id: String?,
    val total: Int?
)
