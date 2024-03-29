package com.tistory.mybstory.coding_test_097.base.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import dagger.android.support.DaggerAppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends DaggerAppCompatActivity {

    public void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    protected void finishWithTransition(int startAnim, int exitAnim) {
        finish();
        overridePendingTransition(startAnim, exitAnim);
    }
}
