package com.midterm.cryptonews.ui.coin_item

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.midterm.cryptonews.databinding.FragmentCoinItemBinding
import com.midterm.cryptonews.enums.fire_opal
import com.midterm.cryptonews.enums.maximum_green
import com.midterm.cryptonews.extensions.setBcgGlide
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.base.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CoinItemFragment : BaseFragment<FragmentCoinItemBinding,CoinItemViewModel>(FragmentCoinItemBinding::inflate) {

    private val args by navArgs<CoinItemFragmentArgs>()

    override fun init() {
        binding.progressBar.visibility = View.VISIBLE
        startObservers()
        viewModel.getCoins(args.coinId,"usd")
    }
    private fun startObservers(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.marketResponse.collect {
                val coin = it.body()!![0]
                if (it.isSuccessful){
                    binding.apply {
                        tvName.text = coin.name!!.plus(" (").plus(coin.symbol!!.uppercase()).plus(")")
                        tvPrice.text = dollarPlus(coin.currentPrice.toString())
                        val percentage = String.format("%.1f", coin.priceChangePercentage24h).toDouble()
                        // Setting Percentage Color Depending On Sign
                        val percentageView = tvPercent
                        val changeSign:String = if (percentage >= 0){
                            percentageView.setTextColor(maximum_green)
                            "+"
                        } else{
                            percentageView.setTextColor(fire_opal)
                            ""
                        }
                        percentageView.text = changeSign.plus(percentage.toString().plus("%"))

                        tvMarketCap.text = dollarPlus(coin.marketCap.toString())
                        tvCirculatingSupply.text = String.format("%.3f",coin.circulatingSupply!!)

                        val totalSupply = coin.totalSupply
                        tvTotalSupply.text = totalSupply?.toString() ?: "∞"

                        val maxSupply = coin.maxSupply
                        tvMaxSupply.text = maxSupply?.toString() ?: "?"

                        tvMarketCapRank.text = "#".plus(coin.marketCapRank!!.toInt().toString())
                        tvDailyHigh.text = dollarPlus(coin.high24h.toString())
                        tvDailyLow.text = dollarPlus(coin.low24h.toString())
                        ivIcon.setBcgGlide(coin.image)

                        // SetUp Graph
                        val graph = lcGraph
                        setUpGraph(graph)
                        val dataSet = LineDataSet(getDataForGraph(coin.sparklineIn7d!!.price!!),"Price")
                        dataSet.color = maximum_green
                        val lineData = LineData(dataSet)
                        graph.data = lineData
                        progressBar.visibility = View.GONE
                        graph.invalidate()
                    }
                }
                else{
                    Log.d("ReqErr",it.message())
                }
            }
        }
    }

    private fun dollarPlus(text:String):String{
        return "$".plus(text)
    }

    private fun getDataForGraph(list:List<Double>):List<Entry>{
        val graphData = mutableListOf<Entry>()
        for(i in list.indices){
            graphData.add(Entry(i.toFloat(),list[i].toFloat()))
        }
        return graphData
    }
    private fun setUpGraph(graph:LineChart){
        graph.apply {
            description.text = "7Day Sparkline"
            description.textColor = Color.WHITE
            xAxis.textColor = Color.WHITE
            axisLeft.textColor = Color.WHITE
            axisRight.textColor = Color.WHITE
            legend.textColor = Color.WHITE
            visibility = View.VISIBLE
        }
    }

    override var useViewModelFactory = true

    override fun getFactory(): ViewModelProvider.Factory = CoinListViewModelFactory(Repository())

    override fun getViewModel(): Class<CoinItemViewModel> = CoinItemViewModel::class.java
}