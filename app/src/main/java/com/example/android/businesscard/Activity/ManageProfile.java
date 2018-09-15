package com.example.android.businesscard.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class ManageProfile extends AppCompatActivity {
    TextView name,edt_email,edt_cnum,edt_website;
    ImageView menu_dot;
    ListView lv;
    FloatingActionButton fab;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);
        name =findViewById(R.id.mpname);
        edt_email =findViewById(R.id.mpemail);
        edt_cnum =findViewById(R.id.mpcontact);
        edt_website =findViewById(R.id.mpwebsite);
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
        name.setText(fname);
        edt_email.setText(email);
        edt_cnum.setText(cnum);
        edt_website.setText(website);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageProfile.this,ProfileActivity.class);
                startActivity(intent);

            }
        });
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        menu_dot = findViewById(R.id.menu_dot);
        menu_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name[] = {"edit","Delete"};

                final Dialog dialog = new Dialog(ManageProfile.this);
                dialog.setContentView(R.layout.list);
                lv = dialog.findViewById(R.id.lv);
                dialog.setCancelable(true);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, name);
                lv.setAdapter(adapter);
                WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes(); //Error here getting window attributes
                wmlp.gravity = Gravity.TOP | Gravity.LEFT;
                wmlp.x = 100;   //x position
                wmlp.y = 100;
                dialog.show();
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                       /* TextView textView = (TextView) view;*/
                        /*edt_title.setText(name[i]);*/
                        dialog.dismiss();
                    }
                });

            }

        });




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
