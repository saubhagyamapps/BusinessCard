package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class VerticleFourth extends AppCompatActivity {
    TextView vf_address, vf_name, vf_title, vf_email, vf_contact, vf_website, vf_post;
    String newString;
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticle_fourth);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.vfourth_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        vf_address = findViewById(R.id.vfo_address);
        vf_email = findViewById(R.id.vfo_email);
        vf_name = findViewById(R.id.vfo_name);
        vf_title = findViewById(R.id.vfo_title);
        vf_contact = findViewById(R.id.vfo_contact);
        vf_website = findViewById(R.id.vfo_website);
        vf_post = findViewById(R.id.vfo_post);
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
        vf_address.setTypeface(font);
        vf_email.setTypeface(font);
        vf_name.setTypeface(font);
        vf_title.setTypeface(font);
        vf_contact.setTypeface(font);
        vf_website.setTypeface(font);
        vf_post.setTypeface(font);
        vf_name.setText(fname);
        vf_title.setText(title);
        vf_contact.setText(cnum);
        vf_email.setText(email);
        vf_website.setText(email);
        vf_address.setText(address);
        vf_post.setText(post);

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
