package com.example.android.businesscard.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.android.businesscard.R;

public class SquareCards extends AppCompatActivity {
    ImageView first,second,third, fourth, fifth,six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_cards);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.stoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        first = findViewById(R.id.sfirst);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareCards.this, SquareFirst.class);
                startActivity(intent);
            }
        });
        second = findViewById(R.id.ssecond);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareCards.this, SquareSecond.class);
                startActivity(intent);
            }
        });
        third = findViewById(R.id.sthird);
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareCards.this, SquareThird.class);
                startActivity(intent);
            }
        });
        fourth = findViewById(R.id.sfourth);
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareCards.this, SquareFourth.class);
                startActivity(intent);
            }
        });
        fifth = findViewById(R.id.sfifth);
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareCards.this, SquareFifth.class);
                startActivity(intent);
            }
        });
        six = findViewById(R.id.ssiz);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SquareCards.this, SquareSix.class);
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
