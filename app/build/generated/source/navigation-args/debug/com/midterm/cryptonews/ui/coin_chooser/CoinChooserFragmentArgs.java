package com.midterm.cryptonews.ui.coin_chooser;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CoinChooserFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CoinChooserFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CoinChooserFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CoinChooserFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CoinChooserFragmentArgs __result = new CoinChooserFragmentArgs();
    bundle.setClassLoader(CoinChooserFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("uid")) {
      String uid;
      uid = bundle.getString("uid");
      if (uid == null) {
        throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("uid", uid);
    } else {
      throw new IllegalArgumentException("Required argument \"uid\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getUid() {
    return (String) arguments.get("uid");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("uid")) {
      String uid = (String) arguments.get("uid");
      __result.putString("uid", uid);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CoinChooserFragmentArgs that = (CoinChooserFragmentArgs) object;
    if (arguments.containsKey("uid") != that.arguments.containsKey("uid")) {
      return false;
    }
    if (getUid() != null ? !getUid().equals(that.getUid()) : that.getUid() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CoinChooserFragmentArgs{"
        + "uid=" + getUid()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(CoinChooserFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String uid) {
      if (uid == null) {
        throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("uid", uid);
    }

    @NonNull
    public CoinChooserFragmentArgs build() {
      CoinChooserFragmentArgs result = new CoinChooserFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setUid(@NonNull String uid) {
      if (uid == null) {
        throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("uid", uid);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUid() {
      return (String) arguments.get("uid");
    }
  }
}
