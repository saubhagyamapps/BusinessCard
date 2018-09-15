package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class RedCardActivity extends AppCompatActivity {
    TextView name,setpost,edt_email,edt_cnum,edt_website,edt_address,edt_title,edt_subtitle;
    private static final String TAG = "GreenCardActivity";
    String newString;
    RelativeLayout relative;
    Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_card);
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("font");
        Log.e(TAG, "hiiiiii: " + newString);
        name =findViewById(R.id.rname);
        setpost =findViewById(R.id.rpost);
        edt_email =findViewById(R.id.remail);
        edt_cnum =findViewById(R.id.rcnum);
        edt_website =findViewById(R.id.rwebsite);
        edt_address =findViewById(R.id.raddress);
        edt_title =findViewById(R.id.rtitle);
        edt_subtitle =findViewById(R.id.rsubtitle);
        SharedPreferences prefs = getSharedPreferences("status", MODE_PRIVATE);
        String fname = prefs.getString("fname", "No name defined");
        String lname = prefs.getString("lname", "No name defined");
        String title = prefs.getString("title", "No name defined");
        String subtitle = prefs.getString("subtitle", "No name defined");
        String post = prefs.getString("post", "No name defined");
        String email = prefs.getString("email", "No name defined");
        String website = prefs.getString("website", "No name defined");
        String address = prefs.getString("address", "No name defined");
        String cnum = prefs.getString("cnum", "No name defined");
        font = Typeface.createFromAsset(getAssets(), "fonts/"+newString);
        name.setTypeface(font);
        setpost.setTypeface(font);
        edt_email.setTypeface(font);
        edt_cnum.setTypeface(font);
        edt_website.setTypeface(font);
        edt_address.setTypeface(font);
        edt_title.setTypeface(font);
        edt_subtitle.setTypeface(font);
        name.setText(fname);
        setpost.setText(post);
        edt_email.setText(email);
        edt_cnum.setText(cnum);
        edt_website.setText(website);
        edt_address.setText(address);
        edt_title.setText(title);
        edt_subtitle.setText(subtitle);
    }
}
