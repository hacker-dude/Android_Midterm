package com.midterm.cryptonews.ui.coin_item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midterm.cryptonews.models.CoinItemModel
import com.midterm.cryptonews.models.MoshiMarketModel
import com.midterm.cryptonews.models.UsdToGelModel
import com.midterm.cryptonews.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoinItemViewModel(private val repository: Repository):ViewModel(){
    private var _marketResponse = MutableSharedFlow<Response<Array<CoinItemModel>>>()
    val marketResponse: Flow<Response<Array<CoinItemModel>>> get() = _marketResponse

    private var _usdToGel = MutableSharedFlow<Double>()
    val usdToGel: Flow<Double> get() = _usdToGel

    fun getCoins(id:String,vs_c:String,order:String = "market_cap_desc",per_page:Int = 100,page:Int = 1,sparkline:Boolean = true){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _marketResponse.emit(repository.getCoinItem(id,vs_c,order,per_page,page,sparkline))
            }
        }
    }
    fun getCurrency(){
        viewModelScope.launch(Dispatchers.IO) {
            _usdToGel.emit(repository.getUsdToGel().usd_gel!!)
        }
    }

}
