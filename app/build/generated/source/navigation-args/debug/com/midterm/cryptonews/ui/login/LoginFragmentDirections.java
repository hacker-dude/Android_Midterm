package com.midterm.cryptonews.ui.login;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginFragmentToRegisterFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment);
  }

  @NonNull
  public static NavDirections actionLoginFragmentToDashboardFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_dashboardFragment);
  }
}
