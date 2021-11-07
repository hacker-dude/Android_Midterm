package com.midterm.cryptonews.ui.profile;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;

public class ProfileFragmentDirections {
  private ProfileFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionProfileFragmentToLoginFragment() {
    return new ActionOnlyNavDirections(R.id.action_profileFragment_to_loginFragment);
  }
}
