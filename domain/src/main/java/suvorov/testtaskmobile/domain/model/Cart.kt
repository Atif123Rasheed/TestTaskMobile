package suvorov.testtaskmobile.domain.model

data class Cart(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)
