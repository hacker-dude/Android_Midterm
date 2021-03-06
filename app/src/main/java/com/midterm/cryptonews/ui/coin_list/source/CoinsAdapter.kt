package com.midterm.cryptonews.ui.coin_list.source

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.CoinListItemBinding
import com.midterm.cryptonews.enums.Currency
import com.midterm.cryptonews.enums.fire_opal
import com.midterm.cryptonews.enums.maximum_green
import com.midterm.cryptonews.extensions.setBcgGlide
import com.midterm.cryptonews.models.MoshiMarketModel
import com.midterm.cryptonews.ui.coin_list.CoinListFragmentDirections

class CoinsAdapter(private val coins:Array<MoshiMarketModel>):RecyclerView.Adapter<CoinsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsAdapter.ViewHolder =
        ViewHolder(CoinListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int = coins.size

    inner class ViewHolder(private val coinView:CoinListItemBinding):RecyclerView.ViewHolder(coinView.root){

        private var coin:MoshiMarketModel? = null
        @SuppressLint("ResourceAsColor")
        fun onBind(){
            coin = coins[bindingAdapterPosition]

            coinView.root.setOnClickListener {
                val direction = CoinListFragmentDirections.actionCoinListFragmentToCoinItemFragment(coin!!.id!!)
                coinView.root.findNavController().navigate(direction)
             }

            val dollar = "$"
            coinView.ivCoinIcon.setBcgGlide(coin?.image)
            coinView.tv24high.text = Currency.HIGH24HRS.message.plus(dollar.plus(String.format("%.2f",coin?.high24h)))
            coinView.tv24low.text = Currency.LOW24HRS.message.plus(dollar.plus(String.format("%.2f",coin?.low24h)))
            coinView.tvName.text = coin?.name.plus("(").plus(coin?.symbol?.uppercase()).plus(")")
            // Setting Percentage Color Depending On Sign
            val percentage = String.format("%.1f", coin?.priceChangePercentage24h).toDouble()
            val percentageView = coinView.tvPercentage
            val changeSign:String = if (percentage >= 0){
                percentageView.setTextColor(maximum_green)
                "+"
            } else{
                percentageView.setTextColor(fire_opal)
                ""
            }
            percentageView.text = changeSign.plus(percentage.toString().plus("%"))
            coinView.tvPrice.text = dollar.plus(coin?.currentPrice.toString())
        }
    }
}