package com.example.android.businesscard.Activity;

import android.app.Dialog;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.businesscard.R;

public class ManageProfile extends AppCompatActivity {
    ImageView menu_dot;
    ListView lv;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);
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

                final Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.list);
                lv = dialog.findViewById(R.id.lv);
                dialog.setCancelable(true);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, name);
                lv.setAdapter(adapter);
                dialog.show();
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
