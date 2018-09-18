package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class VerticleThird extends AppCompatActivity {
    TextView vthi_address, vthi_name, vthi_title, vthi_email, vthi_contact, vthi_website, vthi_post;
    String newString;
    Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticle_third);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.vthird_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        vthi_address = findViewById(R.id.vthi_address);
        vthi_email = findViewById(R.id.vthi_email);
        vthi_name = findViewById(R.id.vthi_name);
        vthi_title = findViewById(R.id.vthi_title);
        vthi_contact = findViewById(R.id.vthi_contact);
        vthi_website = findViewById(R.id.vthi_website);
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
        vthi_address.setTypeface(font);
        vthi_email.setTypeface(font);
        vthi_name.setTypeface(font);
        vthi_title.setTypeface(font);
        vthi_contact.setTypeface(font);
        vthi_website.setTypeface(font);
        vthi_name.setText(fname);
        vthi_title.setText(title);
        vthi_contact.setText(cnum);
        vthi_email.setText(email);
        vthi_website.setText(email);
        vthi_address.setText(address);
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
