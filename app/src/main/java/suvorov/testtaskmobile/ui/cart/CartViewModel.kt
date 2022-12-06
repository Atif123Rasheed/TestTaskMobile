package suvorov.testtaskmobile.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import suvorov.testtaskmobile.domain.model.Cart
import suvorov.testtaskmobile.domain.interactor.MobileInteractor

class CartViewModel(private val interactor: MobileInteractor): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _cart = MutableLiveData<Cart>()
    val cart: LiveData<Cart> = _cart

    fun getCart() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            kotlin.runCatching {
                interactor.getCart()
            }.onSuccess {
                _isLoading.postValue(false)
                _cart.postValue(it)
            }
        }
    }
}