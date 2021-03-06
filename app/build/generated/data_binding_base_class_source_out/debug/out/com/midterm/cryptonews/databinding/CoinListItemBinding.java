// Generated by view binder compiler. Do not edit!
package com.midterm.cryptonews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.midterm.cryptonews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CoinListItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageView ivCoinIcon;

  @NonNull
  public final AppCompatTextView tv24high;

  @NonNull
  public final AppCompatTextView tv24low;

  @NonNull
  public final AppCompatTextView tvName;

  @NonNull
  public final AppCompatTextView tvPercentage;

  @NonNull
  public final AppCompatTextView tvPrice;

  private CoinListItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageView ivCoinIcon, @NonNull AppCompatTextView tv24high,
      @NonNull AppCompatTextView tv24low, @NonNull AppCompatTextView tvName,
      @NonNull AppCompatTextView tvPercentage, @NonNull AppCompatTextView tvPrice) {
    this.rootView = rootView;
    this.ivCoinIcon = ivCoinIcon;
    this.tv24high = tv24high;
    this.tv24low = tv24low;
    this.tvName = tvName;
    this.tvPercentage = tvPercentage;
    this.tvPrice = tvPrice;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CoinListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CoinListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.coin_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CoinListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_coin_icon;
      AppCompatImageView ivCoinIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivCoinIcon == null) {
        break missingId;
      }

      id = R.id.tv_24high;
      AppCompatTextView tv24high = ViewBindings.findChildViewById(rootView, id);
      if (tv24high == null) {
        break missingId;
      }

      id = R.id.tv_24low;
      AppCompatTextView tv24low = ViewBindings.findChildViewById(rootView, id);
      if (tv24low == null) {
        break missingId;
      }

      id = R.id.tv_name;
      AppCompatTextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tv_percentage;
      AppCompatTextView tvPercentage = ViewBindings.findChildViewById(rootView, id);
      if (tvPercentage == null) {
        break missingId;
      }

      id = R.id.tv_price;
      AppCompatTextView tvPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvPrice == null) {
        break missingId;
      }

      return new CoinListItemBinding((ConstraintLayout) rootView, ivCoinIcon, tv24high, tv24low,
          tvName, tvPercentage, tvPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
