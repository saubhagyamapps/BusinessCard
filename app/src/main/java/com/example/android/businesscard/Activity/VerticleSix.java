package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class VerticleSix extends AppCompatActivity {
    TextView s_name, s_title, s_lname, s_post, s_email, s_cnum, s_website, s_address;
    String newString;
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticle_six);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.vsix_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        s_name = findViewById(R.id.s_name);
        s_lname = findViewById(R.id.s_lname);
        s_title = findViewById(R.id.s_title);
        s_cnum = findViewById(R.id.s_cnum);
        s_website = findViewById(R.id.s_website);
        s_post = findViewById(R.id.s_post);
        s_email = findViewById(R.id.s_email);
        s_address = findViewById(R.id.s_address);
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
        s_name.setTypeface(font);
        s_lname.setTypeface(font);
        s_title.setTypeface(font);
        s_cnum.setTypeface(font);
        s_website.setTypeface(font);
        s_post.setTypeface(font);
        s_email.setTypeface(font);
        s_address.setTypeface(font);

        s_lname.setText(lname);
        s_title.setText(title);
        s_cnum.setText(cnum);
        s_name.setText(fname);
        s_website.setText(website);
        s_post.setText(post);
        s_email.setText(email);
        s_address.setText(address);
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
