package com.example.android.businesscard;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.businesscard.Adapter.HorizontalPagerAdapter;
import com.example.android.businesscard.Fragment.DoubleFragment;
import com.example.android.businesscard.Fragment.SingleFragment;
import com.github.florent37.bubbletab.BubbleTab;

public class HorizontalCards extends AppCompatActivity {
    BubbleTab tab;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_cards);

        tab = (BubbleTab) findViewById(R.id.tabs);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tab.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        HorizontalPagerAdapter adapter = new HorizontalPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SingleFragment(), "SINGLE");
        adapter.addFragment(new DoubleFragment(), "DOUBLE");
        viewPager.setAdapter(adapter);
    }

}
