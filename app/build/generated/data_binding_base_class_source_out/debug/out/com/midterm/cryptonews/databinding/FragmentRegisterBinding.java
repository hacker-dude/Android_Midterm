// Generated by view binder compiler. Do not edit!
package com.midterm.cryptonews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.midterm.cryptonews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnRegister;

  @NonNull
  public final TextInputEditText etEmail;

  @NonNull
  public final TextInputEditText etPassword;

  @NonNull
  public final TextInputEditText etUserName;

  @NonNull
  public final TextInputLayout ilEmail;

  @NonNull
  public final TextInputLayout ilPassword;

  @NonNull
  public final TextInputLayout ilUserName;

  @NonNull
  public final AppCompatImageView ivIcon;

  @NonNull
  public final ProgressBar pbRegistering;

  private FragmentRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnRegister, @NonNull TextInputEditText etEmail,
      @NonNull TextInputEditText etPassword, @NonNull TextInputEditText etUserName,
      @NonNull TextInputLayout ilEmail, @NonNull TextInputLayout ilPassword,
      @NonNull TextInputLayout ilUserName, @NonNull AppCompatImageView ivIcon,
      @NonNull ProgressBar pbRegistering) {
    this.rootView = rootView;
    this.btnRegister = btnRegister;
    this.etEmail = etEmail;
    this.etPassword = etPassword;
    this.etUserName = etUserName;
    this.ilEmail = ilEmail;
    this.ilPassword = ilPassword;
    this.ilUserName = ilUserName;
    this.ivIcon = ivIcon;
    this.pbRegistering = pbRegistering;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_register;
      MaterialButton btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.et_email;
      TextInputEditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.et_password;
      TextInputEditText etPassword = ViewBindings.findChildViewById(rootView, id);
      if (etPassword == null) {
        break missingId;
      }

      id = R.id.et_user_name;
      TextInputEditText etUserName = ViewBindings.findChildViewById(rootView, id);
      if (etUserName == null) {
        break missingId;
      }

      id = R.id.il_email;
      TextInputLayout ilEmail = ViewBindings.findChildViewById(rootView, id);
      if (ilEmail == null) {
        break missingId;
      }

      id = R.id.il_password;
      TextInputLayout ilPassword = ViewBindings.findChildViewById(rootView, id);
      if (ilPassword == null) {
        break missingId;
      }

      id = R.id.il_user_name;
      TextInputLayout ilUserName = ViewBindings.findChildViewById(rootView, id);
      if (ilUserName == null) {
        break missingId;
      }

      id = R.id.iv_icon;
      AppCompatImageView ivIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivIcon == null) {
        break missingId;
      }

      id = R.id.pb_registering;
      ProgressBar pbRegistering = ViewBindings.findChildViewById(rootView, id);
      if (pbRegistering == null) {
        break missingId;
      }

      return new FragmentRegisterBinding((ConstraintLayout) rootView, btnRegister, etEmail,
          etPassword, etUserName, ilEmail, ilPassword, ilUserName, ivIcon, pbRegistering);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}