package com.example.android.businesscard.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.android.businesscard.R;

public class MainActivity extends AppCompatActivity {
RelativeLayout profile,horizontal_card,verticle_cards,square_cards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        horizontal_card= findViewById(R.id.horizontal_card);
        horizontal_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HorizontalCards.class);
                startActivity(intent);
            }
        });

        profile= findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ManageProfile.class);
                startActivity(intent);
            }
        });
        square_cards = findViewById(R.id.square_cards);
        square_cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SquareCards.class);
                startActivity(intent);
            }
        });
        verticle_cards = findViewById(R.id.verticle_cards);
        verticle_cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VerticleCards.class);
                startActivity(intent);
            }
        });
    }
}
