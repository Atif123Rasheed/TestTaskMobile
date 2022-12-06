package suvorov.testtaskmobile.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import suvorov.testtaskmobile.domain.model.Phone
import suvorov.testtaskmobile.domain.interactor.MobileInteractor

class DetailViewModel(private val interactor: MobileInteractor): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _phone = MutableLiveData<Phone>()
    val phone: LiveData<Phone> = _phone

    fun getPhone() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            kotlin.runCatching {
                interactor.getPhone()
            }.onSuccess {
                _isLoading.postValue(false)
                _phone.postValue(it)
            }
        }
    }
}