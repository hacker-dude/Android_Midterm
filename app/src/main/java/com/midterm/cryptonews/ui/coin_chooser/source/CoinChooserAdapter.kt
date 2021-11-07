package com.midterm.cryptonews.ui.coin_chooser.source

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.midterm.cryptonews.R
import com.midterm.cryptonews.databinding.CoinChooserItemBinding

class CoinChooserAdapter(
    private val coinList: ArrayList<String>,
    val isGreen: Boolean,
    val itemClick:(name:String,pos:Int) -> Unit
) : RecyclerView.Adapter<CoinChooserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            CoinChooserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = coinList.size

    inner class ViewHolder(private val binding: CoinChooserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val coin = coinList[bindingAdapterPosition]
            val view = binding.ivName
            view.text = coin
            if (isGreen) {
                view.setBackgroundResource(R.drawable.round_border)
            } else {
                view.setBackgroundResource(R.drawable.round_border_red)
            }
            view.setOnClickListener {
                itemClick(coin,bindingAdapterPosition)
            }
        }
    }

}
