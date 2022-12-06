package suvorov.testtaskmobile.util

object PriceHelper {
    fun getPriceRange(price: String): IntRange {
        var priceRange = 0..0
        when(price) {
            "All prices" -> priceRange = 0..10000
            "$0 - $1000" ->  priceRange = 0..1000
            "$1001 - $2000" ->  priceRange = 1001..2000
            "$2001 - $3000" -> priceRange = 2001..3000
            "$3001 - $4000" -> priceRange = 3001..4000
            "$4001 - $5000" -> priceRange = 4001..5000
            "$5001 - $6000" -> priceRange = 5001..6000
            "$6001 - $7000" -> priceRange = 6001..7000
            "$7001 - $8000" -> priceRange = 7001..8000
            "$8001 - $9000" -> priceRange = 8001..9000
            "$9001 - $10000" -> priceRange = 9001..10000
        }
        return priceRange
    }
}
