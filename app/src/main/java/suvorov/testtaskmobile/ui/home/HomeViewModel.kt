package suvorov.testtaskmobile.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import suvorov.testtaskmobile.domain.model.Product
import suvorov.testtaskmobile.domain.interactor.MobileInteractor

class HomeViewModel(private val interactor: MobileInteractor): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> = _product

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            kotlin.runCatching {
                interactor.getProducts()
            }.onSuccess {
                _isLoading.postValue(false)
                _product.postValue(it)
            }
        }
    }
}