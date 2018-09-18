package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class SquareFifth extends AppCompatActivity {
    TextView sfifth_name, sfifth_title, sfifth_contact, sfifth_email, sfifth_website, sfifth_address;
    String newString;
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_fifth);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.sfifth_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        sfifth_name = findViewById(R.id.sfifth_name);
        sfifth_title = findViewById(R.id.sfifth_title);
        sfifth_contact = findViewById(R.id.sfifth_contact);
        sfifth_email = findViewById(R.id.sfifth_email);
        sfifth_website = findViewById(R.id.sfifth_website);
        sfifth_address = findViewById(R.id.sfifth_address);
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
        sfifth_name.setText(fname);
        sfifth_title.setText(title);
        sfifth_contact.setText(cnum);
        sfifth_email.setText(email);
        sfifth_website.setText(website);
        sfifth_address.setText(address);
        sfifth_name.setTypeface(font);
        sfifth_title.setTypeface(font);
        sfifth_contact.setTypeface(font);
        sfifth_email.setTypeface(font);
        sfifth_website.setTypeface(font);
        sfifth_address.setTypeface(font);
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
