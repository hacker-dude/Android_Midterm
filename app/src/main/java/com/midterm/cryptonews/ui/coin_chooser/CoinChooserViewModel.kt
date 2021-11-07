package com.midterm.cryptonews.ui.coin_chooser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.midterm.cryptonews.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CoinChooserViewModel(private val repository: Repository):ViewModel() {
    private var _marketResponse = MutableSharedFlow<ArrayList<String>>()
    val marketResponse: Flow<ArrayList<String>> get() = _marketResponse

    fun getCoins(ids:ArrayList<String>,vs_c:String,order:String = "market_cap_desc",per_page:Int = 50,page:Int = 1,sparkline:Boolean = false){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val resp = repository.getCoinPrices(ids,vs_c,order,per_page,page,sparkline)
                val body = resp.body()
                if(resp.isSuccessful){
                    val coinNames = arrayListOf<String>()
                    for(coin in body!!){
                        coinNames.add(coin.id!!)
                    }
                    _marketResponse.emit(coinNames)
                }else{
                    _marketResponse.emit(arrayListOf())
                }
            }
        }
    }
}
