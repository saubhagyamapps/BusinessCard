package com.example.android.businesscard.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.android.businesscard.Adapter.HorizontalPagerAdapter;
import com.example.android.businesscard.Fragment.DoubleFragment;
import com.example.android.businesscard.Fragment.SingleFragment;
import com.example.android.businesscard.R;
import com.github.florent37.bubbletab.BubbleTab;

public class HorizontalCards extends AppCompatActivity {
    BubbleTab tab;
    private ViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_cards);
        tab =  findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tab.setupWithViewPager(viewPager);

        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }

    private void setupViewPager(ViewPager viewPager) {
        HorizontalPagerAdapter adapter = new HorizontalPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SingleFragment(), "SINGLE");
        adapter.addFragment(new DoubleFragment(), "DOUBLE");
        viewPager.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
