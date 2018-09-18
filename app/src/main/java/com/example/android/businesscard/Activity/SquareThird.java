package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class SquareThird extends AppCompatActivity {
    TextView sthird_name, sthird_title, sthird_contact, sthird_email, sthird_website, sthird_address;
    String newString;
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_third);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.sthird_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        sthird_name = findViewById(R.id.sthird_name);
        sthird_title = findViewById(R.id.sthird_title);
        sthird_contact = findViewById(R.id.sthird_contact);
        sthird_email = findViewById(R.id.sthird_email);
        sthird_website = findViewById(R.id.sthird_website);
        sthird_address = findViewById(R.id.sthird_address);
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
        sthird_name.setText(fname);
        sthird_title.setText(title);
        sthird_contact.setText(cnum);
        sthird_email.setText(email);
        sthird_website.setText(website);
        sthird_address.setText(address);
        sthird_name.setTypeface(font);
        sthird_title.setTypeface(font);
        sthird_contact.setTypeface(font);
        sthird_email.setTypeface(font);
        sthird_website.setTypeface(font);
        sthird_address.setTypeface(font);
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
