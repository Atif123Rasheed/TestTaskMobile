package suvorov.testaskmobile.data.model

import com.google.gson.annotations.SerializedName

data class ProductApi(
    @SerializedName("home_store") val homeStore: List<HomeStoreApi>,
    @SerializedName("best_seller") val bestSeller: List<BestSellerApi>
)