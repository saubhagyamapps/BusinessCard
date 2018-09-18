package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class SquareFirst extends AppCompatActivity {
    TextView sfirst_unifield, sfirst_apps,sfirst_txtphone,sfirst_phone,sfirst_txtemail,sfirst_email,sfirst_txtwebsite,sfirst_website;
    String newString;
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_first);
        sfirst_unifield = findViewById(R.id.sfirst_unifield);
        sfirst_apps = findViewById(R.id.sfirst_apps);
        sfirst_txtphone = findViewById(R.id.sfirst_txtphone);
        sfirst_phone = findViewById(R.id.sfirst_phone);
        sfirst_txtemail = findViewById(R.id.sfirst_txtemail);
        sfirst_email = findViewById(R.id.sfirst_email);
        sfirst_txtwebsite = findViewById(R.id.sfirst_txtwebsite);
        sfirst_website = findViewById(R.id.sfirst_website);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("font");
        font = Typeface.createFromAsset(getAssets(), "fonts/"+newString);

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
        sfirst_unifield.setText(fname);
        sfirst_unifield.setTypeface(font);
        sfirst_apps.setText(title);
        sfirst_apps.setTypeface(font);
        sfirst_phone.setText(cnum);
        sfirst_phone.setTypeface(font);
        sfirst_email.setText(email);
        sfirst_email.setTypeface(font);
        sfirst_website.setText(email);
        sfirst_website.setTypeface(font);
        sfirst_txtphone.setTypeface(font);
        sfirst_txtemail.setTypeface(font);
        sfirst_txtwebsite.setTypeface(font);

        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.sfirst_toolbar);
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
