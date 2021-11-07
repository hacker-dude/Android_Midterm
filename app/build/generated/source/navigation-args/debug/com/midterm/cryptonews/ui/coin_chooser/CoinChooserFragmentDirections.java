package com.midterm.cryptonews.ui.coin_chooser;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;

public class CoinChooserFragmentDirections {
  private CoinChooserFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCoinChooserFragmentToCoinListFragment() {
    return new ActionOnlyNavDirections(R.id.action_coinChooserFragment_to_coinListFragment);
  }
}
