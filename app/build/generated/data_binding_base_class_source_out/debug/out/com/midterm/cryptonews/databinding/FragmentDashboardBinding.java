// Generated by view binder compiler. Do not edit!
package com.midterm.cryptonews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.midterm.cryptonews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageButton btnList;

  @NonNull
  public final AppCompatImageButton btnProfile;

  @NonNull
  public final RecyclerView newsRecycler;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final SwipeRefreshLayout srlNewsRefresher;

  @NonNull
  public final AppCompatImageView tvLogo;

  @NonNull
  public final View vHeader;

  private FragmentDashboardBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageButton btnList, @NonNull AppCompatImageButton btnProfile,
      @NonNull RecyclerView newsRecycler, @NonNull ProgressBar progressBar,
      @NonNull SwipeRefreshLayout srlNewsRefresher, @NonNull AppCompatImageView tvLogo,
      @NonNull View vHeader) {
    this.rootView = rootView;
    this.btnList = btnList;
    this.btnProfile = btnProfile;
    this.newsRecycler = newsRecycler;
    this.progressBar = progressBar;
    this.srlNewsRefresher = srlNewsRefresher;
    this.tvLogo = tvLogo;
    this.vHeader = vHeader;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_list;
      AppCompatImageButton btnList = ViewBindings.findChildViewById(rootView, id);
      if (btnList == null) {
        break missingId;
      }

      id = R.id.btn_profile;
      AppCompatImageButton btnProfile = ViewBindings.findChildViewById(rootView, id);
      if (btnProfile == null) {
        break missingId;
      }

      id = R.id.news_recycler;
      RecyclerView newsRecycler = ViewBindings.findChildViewById(rootView, id);
      if (newsRecycler == null) {
        break missingId;
      }

      id = R.id.progress_bar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.srl_news_refresher;
      SwipeRefreshLayout srlNewsRefresher = ViewBindings.findChildViewById(rootView, id);
      if (srlNewsRefresher == null) {
        break missingId;
      }

      id = R.id.tv_logo;
      AppCompatImageView tvLogo = ViewBindings.findChildViewById(rootView, id);
      if (tvLogo == null) {
        break missingId;
      }

      id = R.id.v_header;
      View vHeader = ViewBindings.findChildViewById(rootView, id);
      if (vHeader == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((ConstraintLayout) rootView, btnList, btnProfile,
          newsRecycler, progressBar, srlNewsRefresher, tvLogo, vHeader);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}