package com.midterm.cryptonews.ui.coin_item;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CoinItemFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CoinItemFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CoinItemFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CoinItemFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CoinItemFragmentArgs __result = new CoinItemFragmentArgs();
    bundle.setClassLoader(CoinItemFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("coin_id")) {
      String coinId;
      coinId = bundle.getString("coin_id");
      if (coinId == null) {
        throw new IllegalArgumentException("Argument \"coin_id\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("coin_id", coinId);
    } else {
      throw new IllegalArgumentException("Required argument \"coin_id\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getCoinId() {
    return (String) arguments.get("coin_id");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("coin_id")) {
      String coinId = (String) arguments.get("coin_id");
      __result.putString("coin_id", coinId);
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
    CoinItemFragmentArgs that = (CoinItemFragmentArgs) object;
    if (arguments.containsKey("coin_id") != that.arguments.containsKey("coin_id")) {
      return false;
    }
    if (getCoinId() != null ? !getCoinId().equals(that.getCoinId()) : that.getCoinId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCoinId() != null ? getCoinId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CoinItemFragmentArgs{"
        + "coinId=" + getCoinId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(CoinItemFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String coinId) {
      if (coinId == null) {
        throw new IllegalArgumentException("Argument \"coin_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("coin_id", coinId);
    }

    @NonNull
    public CoinItemFragmentArgs build() {
      CoinItemFragmentArgs result = new CoinItemFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCoinId(@NonNull String coinId) {
      if (coinId == null) {
        throw new IllegalArgumentException("Argument \"coin_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("coin_id", coinId);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCoinId() {
      return (String) arguments.get("coin_id");
    }
  }
}
