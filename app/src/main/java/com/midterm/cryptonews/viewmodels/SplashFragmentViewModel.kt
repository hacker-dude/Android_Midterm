package com.midterm.cryptonews.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midterm.cryptonews.models.UsdToGelModel
import com.midterm.cryptonews.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragmentViewModel(private val repository: Repository):ViewModel() {

    private var _usdToGel = MutableLiveData<UsdToGelModel>()
    val usdToGel:LiveData<UsdToGelModel> get() = _usdToGel

    fun getUsdToGel(){
        viewModelScope.launch {
            withContext(IO){
                _usdToGel.postValue(repository.getUsdToGel().body()!!)
            }
        }
    }

}