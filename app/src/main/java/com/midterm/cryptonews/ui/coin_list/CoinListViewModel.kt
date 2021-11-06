package com.midterm.cryptonews.ui.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midterm.cryptonews.models.MoshiMarketModel
import com.midterm.cryptonews.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoinListViewModel(private val repository: Repository) : ViewModel(){

    private var _marketResponse = MutableSharedFlow<Response<Array<MoshiMarketModel>>>()
    val marketResponse: Flow<Response<Array<MoshiMarketModel>>> get() = _marketResponse

    fun getCoins(ids:ArrayList<String>,vs_c:String,order:String = "market_cap_desc",per_page:Int = 100,page:Int = 1,sparkline:Boolean = false){
        viewModelScope.launch {
            withContext(IO){
                _marketResponse.emit(repository.getCoinPrices(ids,vs_c,order,per_page,page,sparkline))
            }
        }
    }
}
