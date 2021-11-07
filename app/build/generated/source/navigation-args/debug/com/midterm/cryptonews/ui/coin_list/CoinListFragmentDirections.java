package com.midterm.cryptonews.ui.coin_list;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.midterm.cryptonews.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CoinListFragmentDirections {
  private CoinListFragmentDirections() {
  }

  @NonNull
  public static ActionCoinListFragmentToCoinChooserFragment actionCoinListFragmentToCoinChooserFragment(
      @NonNull String uid) {
    return new ActionCoinListFragmentToCoinChooserFragment(uid);
  }

  @NonNull
  public static ActionCoinListFragmentToCoinItemFragment actionCoinListFragmentToCoinItemFragment(
      @NonNull String coinId) {
    return new ActionCoinListFragmentToCoinItemFragment(coinId);
  }

  public static class ActionCoinListFragmentToCoinChooserFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionCoinListFragmentToCoinChooserFragment(@NonNull String uid) {
      if (uid == null) {
        throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("uid", uid);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCoinListFragmentToCoinChooserFragment setUid(@NonNull String uid) {
      if (uid == null) {
        throw new IllegalArgumentException("Argument \"uid\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("uid", uid);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("uid")) {
        String uid = (String) arguments.get("uid");
        __result.putString("uid", uid);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_coinListFragment_to_coinChooserFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getUid() {
      return (String) arguments.get("uid");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCoinListFragmentToCoinChooserFragment that = (ActionCoinListFragmentToCoinChooserFragment) object;
      if (arguments.containsKey("uid") != that.arguments.containsKey("uid")) {
        return false;
      }
      if (getUid() != null ? !getUid().equals(that.getUid()) : that.getUid() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCoinListFragmentToCoinChooserFragment(actionId=" + getActionId() + "){"
          + "uid=" + getUid()
          + "}";
    }
  }

  public static class ActionCoinListFragmentToCoinItemFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionCoinListFragmentToCoinItemFragment(@NonNull String coinId) {
      if (coinId == null) {
        throw new IllegalArgumentException("Argument \"coin_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("coin_id", coinId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCoinListFragmentToCoinItemFragment setCoinId(@NonNull String coinId) {
      if (coinId == null) {
        throw new IllegalArgumentException("Argument \"coin_id\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("coin_id", coinId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("coin_id")) {
        String coinId = (String) arguments.get("coin_id");
        __result.putString("coin_id", coinId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_coinListFragment_to_coinItemFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCoinId() {
      return (String) arguments.get("coin_id");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCoinListFragmentToCoinItemFragment that = (ActionCoinListFragmentToCoinItemFragment) object;
      if (arguments.containsKey("coin_id") != that.arguments.containsKey("coin_id")) {
        return false;
      }
      if (getCoinId() != null ? !getCoinId().equals(that.getCoinId()) : that.getCoinId() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getCoinId() != null ? getCoinId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCoinListFragmentToCoinItemFragment(actionId=" + getActionId() + "){"
          + "coinId=" + getCoinId()
          + "}";
    }
  }
}
