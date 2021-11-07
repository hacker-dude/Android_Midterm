package com.midterm.cryptonews.ui.splash_screen;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;

public class SplashFragmentDirections {
  private SplashFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSplashFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashFragment_to_loginFragment);
  }

  @NonNull
  public static NavDirections actionSplashFragmentToDashboardFragment() {
    return new ActionOnlyNavDirections(R.id.action_splashFragment_to_dashboardFragment);
  }
}
