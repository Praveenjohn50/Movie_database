package com.example.praveen.movieupdates.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.praveen.movieupdates.R;
import com.example.praveen.movieupdates.fragments.PopularMoviesFragment;

public class CustomDialogClass extends Dialog implements
    android.view.View.OnClickListener {

  public Activity c;
  public Dialog d;
  public Button exit;
  public PopularMoviesFragment mPopularMoviesFragment;

  public CustomDialogClass(Activity a, PopularMoviesFragment popularMoviesFragment) {
    super(a);
    this.c = a;
    this.mPopularMoviesFragment = popularMoviesFragment;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.alert_dialog);
    exit = (Button) findViewById(R.id.exit_btn);
    exit.setOnClickListener(this);


  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.exit_btn:
        dismiss();
        break;
    default:
      break;
    }
  }
}