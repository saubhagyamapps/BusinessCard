package com.example.android.businesscard.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.android.businesscard.R;

public class FontActivity extends AppCompatActivity {
    RadioButton AlexBrush, bauhaus, OpenSans, Oswald, Roboto, segoeui;
    TextView txt,tfirst,tsecond,tthird,tfour,tfive,tsix;
    Button Next;
    String newString;
    private static final String TAG = "FontActivity";
    Typeface font;
    String FontName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);

        tfirst = findViewById(R.id.tfirst);
        font = Typeface.createFromAsset(getAssets(), "fonts/AlexBrush.ttf");
        FontName = "AlexBrush.ttf";
        tfirst.setTypeface(font);

        tsecond = findViewById(R.id.tsecond);
        font = Typeface.createFromAsset(getAssets(), "fonts/bauhaus.ttf");
        FontName = "bauhaus.ttf";
        tsecond.setTypeface(font);

        tthird = findViewById(R.id.tthird);
        font = Typeface.createFromAsset(getAssets(), "fonts/OpenSans.ttf");
        FontName = "OpenSans.ttf";
        tthird.setTypeface(font);

        tfour = findViewById(R.id.tfour);
        font = Typeface.createFromAsset(getAssets(), "fonts/Oswald.ttf");
        FontName = "Oswald.ttf";
        tfour.setTypeface(font);

        tfive = findViewById(R.id.tfive);
        font = Typeface.createFromAsset(getAssets(), "fonts/Roboto.ttf");
        FontName = "Roboto.ttf";
        tfive.setTypeface(font);

        tsix = findViewById(R.id.tsix);
        font = Typeface.createFromAsset(getAssets(), "fonts/segoeui.ttf");
        FontName = "segoeui.ttf";
        tsix.setTypeface(font);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                newString = null;
            } else {
                newString = extras.getString("value");
                Log.e(TAG, "onCreate: " + newString);
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("value");
        }
        Next = findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newString.equals("red")) {
                    Intent intent = new Intent(FontActivity.this, RedCardActivity.class);
                    intent.putExtra("font", FontName);
                    startActivity(intent);


                } else {
                    Intent intent = new Intent(FontActivity.this, GreenCardActivity.class);
                    intent.putExtra("font", FontName);
                    startActivity(intent);

                }
            }
        });
        txt = findViewById(R.id.txt);
        AlexBrush = findViewById(R.id.alexbrush);
        AlexBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font = Typeface.createFromAsset(getAssets(), "fonts/AlexBrush.ttf");
                FontName = "AlexBrush.ttf";
                txt.setTypeface(font);
            }
        });
        bauhaus = findViewById(R.id.bauhaus);
        bauhaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font = Typeface.createFromAsset(getAssets(), "fonts/bauhaus.ttf");
                FontName = "bauhaus.ttf";
                txt.setTypeface(font);
            }
        });
        OpenSans = findViewById(R.id.opensans);
        OpenSans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font = Typeface.createFromAsset(getAssets(), "fonts/OpenSans.ttf");
                FontName = "OpenSans.ttf";
                txt.setTypeface(font);
            }
        });
        Oswald = findViewById(R.id.oswald);
        Oswald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font = Typeface.createFromAsset(getAssets(), "fonts/Oswald.ttf");
                FontName = "Oswald.ttf";
                txt.setTypeface(font);
            }
        });
        Roboto = findViewById(R.id.roboto);
        Roboto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font = Typeface.createFromAsset(getAssets(), "fonts/Roboto.ttf");
                FontName = "Roboto.ttf";
                txt.setTypeface(font);
            }
        });
        segoeui = findViewById(R.id.segoeui);
        segoeui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                font = Typeface.createFromAsset(getAssets(), "fonts/segoeui.ttf");
                FontName = "segoeui.ttf";
                txt.setTypeface(font);
            }
        });
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.font_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
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
