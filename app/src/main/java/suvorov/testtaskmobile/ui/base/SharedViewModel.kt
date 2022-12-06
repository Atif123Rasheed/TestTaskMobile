package suvorov.testtaskmobile.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private val _brand = MutableLiveData<String>()
    val brand: LiveData<String> = _brand

    private val _priceRange = MutableLiveData<IntRange>()
    val priceRange: LiveData<IntRange> = _priceRange

    private val _basket = MutableLiveData<Int>()
    val basket: LiveData<Int> = _basket

    fun saveBrand(value: String) {
        _brand.value = value
    }

    fun savePriceRange(value: IntRange) {
        _priceRange.value = value
    }

    fun saveBasket(value: Int) {
        _basket.value = value
    }
}