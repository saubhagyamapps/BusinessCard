package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class VerticleFifth extends AppCompatActivity {
    TextView  b_name, b_title, b_email, b_contact, b_website;
    String newString;
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticle_fifth);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.vfifth_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        b_email = findViewById(R.id.b_email);
        b_name = findViewById(R.id.b_name);
        b_title = findViewById(R.id.b_title);
        b_contact = findViewById(R.id.b_contact);
        b_website = findViewById(R.id.b_website);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("font");
        font = Typeface.createFromAsset(getAssets(), "fonts/" + newString);

        SharedPreferences prefs = getSharedPreferences("status", MODE_PRIVATE);
        String fname = prefs.getString("fname", "Abc");
        String lname = prefs.getString("lname", "Abc");
        String title = prefs.getString("title", "Abc");
        String subtitle = prefs.getString("subtitle", "Abc");
        String post = prefs.getString("post", "Abc");
        String email = prefs.getString("email", "Abc");
        String website = prefs.getString("website", "Abc");
        String address = prefs.getString("address", "Abc");
        String cnum = prefs.getString("cnum", "Abc");
        b_email.setTypeface(font);
        b_name.setTypeface(font);
        b_title.setTypeface(font);
        b_contact.setTypeface(font);
        b_website.setTypeface(font);
        b_name.setText(fname);
        b_title.setText(title);
        b_contact.setText(cnum);
        b_email.setText(email);
        b_website.setText(email);
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
