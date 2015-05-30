package com.gettingstarted.lauresoft.reddittest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentholder, PostsFragment.newInstance("askreddit")).commit();
    }


}
