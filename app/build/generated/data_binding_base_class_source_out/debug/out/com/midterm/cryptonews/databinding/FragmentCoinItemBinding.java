// Generated by view binder compiler. Do not edit!
package com.midterm.cryptonews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.button.MaterialButton;
import com.midterm.cryptonews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCoinItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnToGel;

  @NonNull
  public final MaterialButton btnToUsd;

  @NonNull
  public final AppCompatTextView circulatingSupply;

  @NonNull
  public final AppCompatTextView dailyLowHigh;

  @NonNull
  public final AppCompatImageView ivIcon;

  @NonNull
  public final LineChart lcGraph;

  @NonNull
  public final AppCompatTextView marketCap;

  @NonNull
  public final AppCompatTextView marketCapRank;

  @NonNull
  public final AppCompatTextView maxSupply;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final AppCompatTextView slash;

  @NonNull
  public final AppCompatTextView totalSupply;

  @NonNull
  public final AppCompatTextView tvCirculatingSupply;

  @NonNull
  public final AppCompatTextView tvDailyHigh;

  @NonNull
  public final AppCompatTextView tvDailyLow;

  @NonNull
  public final AppCompatTextView tvMarketCap;

  @NonNull
  public final AppCompatTextView tvMarketCapRank;

  @NonNull
  public final AppCompatTextView tvMaxSupply;

  @NonNull
  public final AppCompatTextView tvName;

  @NonNull
  public final AppCompatTextView tvPercent;

  @NonNull
  public final AppCompatTextView tvPrice;

  @NonNull
  public final AppCompatTextView tvTotalSupply;

  private FragmentCoinItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnToGel, @NonNull MaterialButton btnToUsd,
      @NonNull AppCompatTextView circulatingSupply, @NonNull AppCompatTextView dailyLowHigh,
      @NonNull AppCompatImageView ivIcon, @NonNull LineChart lcGraph,
      @NonNull AppCompatTextView marketCap, @NonNull AppCompatTextView marketCapRank,
      @NonNull AppCompatTextView maxSupply, @NonNull ProgressBar progressBar,
      @NonNull AppCompatTextView slash, @NonNull AppCompatTextView totalSupply,
      @NonNull AppCompatTextView tvCirculatingSupply, @NonNull AppCompatTextView tvDailyHigh,
      @NonNull AppCompatTextView tvDailyLow, @NonNull AppCompatTextView tvMarketCap,
      @NonNull AppCompatTextView tvMarketCapRank, @NonNull AppCompatTextView tvMaxSupply,
      @NonNull AppCompatTextView tvName, @NonNull AppCompatTextView tvPercent,
      @NonNull AppCompatTextView tvPrice, @NonNull AppCompatTextView tvTotalSupply) {
    this.rootView = rootView;
    this.btnToGel = btnToGel;
    this.btnToUsd = btnToUsd;
    this.circulatingSupply = circulatingSupply;
    this.dailyLowHigh = dailyLowHigh;
    this.ivIcon = ivIcon;
    this.lcGraph = lcGraph;
    this.marketCap = marketCap;
    this.marketCapRank = marketCapRank;
    this.maxSupply = maxSupply;
    this.progressBar = progressBar;
    this.slash = slash;
    this.totalSupply = totalSupply;
    this.tvCirculatingSupply = tvCirculatingSupply;
    this.tvDailyHigh = tvDailyHigh;
    this.tvDailyLow = tvDailyLow;
    this.tvMarketCap = tvMarketCap;
    this.tvMarketCapRank = tvMarketCapRank;
    this.tvMaxSupply = tvMaxSupply;
    this.tvName = tvName;
    this.tvPercent = tvPercent;
    this.tvPrice = tvPrice;
    this.tvTotalSupply = tvTotalSupply;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCoinItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCoinItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_coin_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCoinItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_to_gel;
      MaterialButton btnToGel = ViewBindings.findChildViewById(rootView, id);
      if (btnToGel == null) {
        break missingId;
      }

      id = R.id.btn_to_usd;
      MaterialButton btnToUsd = ViewBindings.findChildViewById(rootView, id);
      if (btnToUsd == null) {
        break missingId;
      }

      id = R.id.circulating_supply;
      AppCompatTextView circulatingSupply = ViewBindings.findChildViewById(rootView, id);
      if (circulatingSupply == null) {
        break missingId;
      }

      id = R.id.daily_low_high;
      AppCompatTextView dailyLowHigh = ViewBindings.findChildViewById(rootView, id);
      if (dailyLowHigh == null) {
        break missingId;
      }

      id = R.id.iv_icon;
      AppCompatImageView ivIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivIcon == null) {
        break missingId;
      }

      id = R.id.lc_graph;
      LineChart lcGraph = ViewBindings.findChildViewById(rootView, id);
      if (lcGraph == null) {
        break missingId;
      }

      id = R.id.market_cap;
      AppCompatTextView marketCap = ViewBindings.findChildViewById(rootView, id);
      if (marketCap == null) {
        break missingId;
      }

      id = R.id.market_cap_rank;
      AppCompatTextView marketCapRank = ViewBindings.findChildViewById(rootView, id);
      if (marketCapRank == null) {
        break missingId;
      }

      id = R.id.max_supply;
      AppCompatTextView maxSupply = ViewBindings.findChildViewById(rootView, id);
      if (maxSupply == null) {
        break missingId;
      }

      id = R.id.progress_bar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.slash;
      AppCompatTextView slash = ViewBindings.findChildViewById(rootView, id);
      if (slash == null) {
        break missingId;
      }

      id = R.id.total_supply;
      AppCompatTextView totalSupply = ViewBindings.findChildViewById(rootView, id);
      if (totalSupply == null) {
        break missingId;
      }

      id = R.id.tv_circulating_supply;
      AppCompatTextView tvCirculatingSupply = ViewBindings.findChildViewById(rootView, id);
      if (tvCirculatingSupply == null) {
        break missingId;
      }

      id = R.id.tv_daily_high;
      AppCompatTextView tvDailyHigh = ViewBindings.findChildViewById(rootView, id);
      if (tvDailyHigh == null) {
        break missingId;
      }

      id = R.id.tv_daily_low;
      AppCompatTextView tvDailyLow = ViewBindings.findChildViewById(rootView, id);
      if (tvDailyLow == null) {
        break missingId;
      }

      id = R.id.tv_market_cap;
      AppCompatTextView tvMarketCap = ViewBindings.findChildViewById(rootView, id);
      if (tvMarketCap == null) {
        break missingId;
      }

      id = R.id.tv_market_cap_rank;
      AppCompatTextView tvMarketCapRank = ViewBindings.findChildViewById(rootView, id);
      if (tvMarketCapRank == null) {
        break missingId;
      }

      id = R.id.tv_max_supply;
      AppCompatTextView tvMaxSupply = ViewBindings.findChildViewById(rootView, id);
      if (tvMaxSupply == null) {
        break missingId;
      }

      id = R.id.tv_name;
      AppCompatTextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tv_percent;
      AppCompatTextView tvPercent = ViewBindings.findChildViewById(rootView, id);
      if (tvPercent == null) {
        break missingId;
      }

      id = R.id.tv_price;
      AppCompatTextView tvPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvPrice == null) {
        break missingId;
      }

      id = R.id.tv_total_supply;
      AppCompatTextView tvTotalSupply = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalSupply == null) {
        break missingId;
      }

      return new FragmentCoinItemBinding((ConstraintLayout) rootView, btnToGel, btnToUsd,
          circulatingSupply, dailyLowHigh, ivIcon, lcGraph, marketCap, marketCapRank, maxSupply,
          progressBar, slash, totalSupply, tvCirculatingSupply, tvDailyHigh, tvDailyLow,
          tvMarketCap, tvMarketCapRank, tvMaxSupply, tvName, tvPercent, tvPrice, tvTotalSupply);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
