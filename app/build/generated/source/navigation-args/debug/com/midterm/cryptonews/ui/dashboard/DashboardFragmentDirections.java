package com.midterm.cryptonews.ui.dashboard;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;

public class DashboardFragmentDirections {
  private DashboardFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToCoinListFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_coinListFragment);
  }

  @NonNull
  public static NavDirections actionDashboardFragmentToProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_dashboardFragment_to_profileFragment);
  }
}
