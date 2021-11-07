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
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.FragmentCoinItemBinding
import com.midterm.cryptonews.enums.fire_opal
import com.midterm.cryptonews.enums.maximum_green
import com.midterm.cryptonews.extensions.setBcgGlide
import com.midterm.cryptonews.models.CoinItemModel
import com.midterm.cryptonews.repository.Repository
import com.midterm.cryptonews.ui.base.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class CoinItemFragment :
    BaseFragment<FragmentCoinItemBinding, CoinItemViewModel>(FragmentCoinItemBinding::inflate) {

    private val args by navArgs<CoinItemFragmentArgs>()
    private var usdToGel: Double = -1.0
    private var currency = "usd"
    private lateinit var coin: CoinItemModel

    override fun init() {
        enableButtons(false)
        binding.progressBar.visibility = View.VISIBLE
        startObservers()
        listeners()
        viewModel.getCoins(args.coinId, "usd")
        viewModel.getCurrency()
    }

    private fun startObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.marketResponse.collect {
                coin = it.body()!![0]
                if (it.isSuccessful) {
                    binding.apply {
                        tvName.text =
                            coin.name!!.plus(" (").plus(coin.symbol!!.uppercase()).plus(")")
                        tvPrice.text = dollarPlus(coin.currentPrice.toString())
                        val percentage =
                            String.format("%.1f", coin.priceChangePercentage24h).toDouble()
                        // Setting Percentage Color Depending On Sign
                        val percentageView = tvPercent
                        val changeSign: String = if (percentage >= 0) {
                            percentageView.setTextColor(maximum_green)
                            "+"
                        } else {
                            percentageView.setTextColor(fire_opal)
                            ""
                        }
                        percentageView.text = changeSign.plus(percentage.toString().plus("%"))

                        tvMarketCap.text = dollarPlus(coin.marketCap.toString())
                        tvCirculatingSupply.text = String.format("%.3f", coin.circulatingSupply!!)

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
                        val dataSet =
                            LineDataSet(getDataForGraph(coin.sparklineIn7d!!.price!!), "Price")
                        dataSet.color = maximum_green
                        val lineData = LineData(dataSet)
                        graph.data = lineData
                        progressBar.visibility = View.GONE
                        enableButtons(true)
                        graph.invalidate()
                    }
                } else {
                    Log.d("ReqErr", it.message())
                }
            }


        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.usdToGel.collect {
                Log.d("testThis", it.toString())
                usdToGel = it
            }
        }
    }

    private fun dollarPlus(text: String): String {
        return "$".plus(text)
    }

    private fun gelPlus(text: String): String {
        return "₾".plus(text)
    }

    private fun getDataForGraph(list: List<Double>): List<Entry> {
        val graphData = mutableListOf<Entry>()
        for (i in list.indices) {
            graphData.add(Entry(i.toFloat(), list[i].toFloat()))
        }
        return graphData
    }

    private fun setUpGraph(graph: LineChart) {
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

    private fun listeners() {
        binding.apply {
            btnToGel.setOnClickListener { currency = "gel";changeCurrency() }
            btnToUsd.setOnClickListener { currency = "usd";changeCurrency() }
        }
    }

    private fun changeCurrency() {
        if (currency == "usd" && usdToGel != -1.0) {
            binding.apply {
                tvPrice.text = gelPlus(String.format("%.9f", coin.currentPrice!! * usdToGel))
                tvMarketCap.text = gelPlus(String.format("%.1f", coin.marketCap!! * usdToGel))
                tvDailyHigh.text = gelPlus(String.format("%.6f", coin.high24h!! * usdToGel))
                tvDailyLow.text = gelPlus(String.format("%.6f", coin.low24h!! * usdToGel))
                btnToGel.setTextColor(resources.getColor(R.color.middle_red))
                btnToUsd.setTextColor(resources.getColor(R.color.cornflower_blue))
            }
        } else {
            binding.apply {
                tvPrice.text = dollarPlus(String.format("%.6f", coin.currentPrice))
                tvMarketCap.text = dollarPlus(coin.marketCap.toString())
                tvDailyHigh.text = dollarPlus(String.format("%.6f", coin.high24h))
                tvDailyLow.text = dollarPlus(String.format("%.6f", coin.low24h))
                btnToGel.setTextColor(resources.getColor(R.color.cornflower_blue))
                btnToUsd.setTextColor(resources.getColor(R.color.middle_red))
            }
        }
    }

    private fun enableButtons(state: Boolean) {
        binding.apply {
            btnToGel.isClickable = state
            btnToUsd.isClickable = state
        }
    }

    override var useViewModelFactory = true

    override fun getFactory(): ViewModelProvider.Factory = CoinListViewModelFactory(Repository())

    override fun getViewModel(): Class<CoinItemViewModel> = CoinItemViewModel::class.java
}