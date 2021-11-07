package com.midterm.cryptonews.ui.register;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;

public class RegisterFragmentDirections {
  private RegisterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRegisterFragmentToDashboardFragment() {
    return new ActionOnlyNavDirections(R.id.action_registerFragment_to_dashboardFragment);
  }
}
