package com.example.android.businesscard.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.android.businesscard.R;

public class VerticleCards extends AppCompatActivity {
    ImageView first,second,third, fourth, fifth,six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticle_cards);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.vtoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        first = findViewById(R.id.vfirst);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerticleCards.this, FontActivity.class);
                intent.putExtra("value", "vfirst");
                startActivity(intent);
            }
        });
        second = findViewById(R.id.vsecond);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerticleCards.this, FontActivity.class);
                intent.putExtra("value", "vsecond");
                startActivity(intent);
            }
        });
        third = findViewById(R.id.vthird);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerticleCards.this, FontActivity.class);
                intent.putExtra("value", "vthird");
                startActivity(intent);
            }
        });
        fourth = findViewById(R.id.vfourth);
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerticleCards.this, FontActivity.class);
                intent.putExtra("value", "vfourth");
                startActivity(intent);
            }
        });
        fifth = findViewById(R.id.vfifth);
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerticleCards.this, FontActivity.class);
                intent.putExtra("value", "vfive");
                startActivity(intent);
            }
        });
        six = findViewById(R.id.vsix);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerticleCards.this, FontActivity.class);
                intent.putExtra("value", "vsix");
                startActivity(intent);
            }
        });
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
