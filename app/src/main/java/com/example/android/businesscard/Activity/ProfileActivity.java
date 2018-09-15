package com.example.android.businesscard.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android.businesscard.R;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "MyProfile";
    private static int RESULT_LOAD_IMAGE = 1;
    CollapsingToolbarLayout toolbarLayout;
    FloatingActionButton fab;
    /*    DatabaseHelper databaseHelper;*/
    Button save;
    EditText fname, lname, email, address, business_title, business_subtitle, post, website, cnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        save = findViewById(R.id.save);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        business_subtitle = findViewById(R.id.business_subtitle);
        business_title = findViewById(R.id.business_title);
        cnum = findViewById(R.id.contact_num);
        post = findViewById(R.id.post);
        website = findViewById(R.id.website);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    String newEntry = textInputEditText.getText().toString();
                addData(newEntry);
                Toast.makeText(ProfileActivity.this, newEntry, Toast.LENGTH_SHORT).show();*/

                if (fname.getText().toString().equals("")) {
                    fname.setError("Enter Firstname");
                } else if (lname.getText().toString().equals("")) {
                    lname.setError("Enter Lastname");
                } else if (business_title.getText().toString().equals("")) {
                    business_title.setError("Enter Title");
                } else if (business_subtitle.getText().toString().equals("")) {
                    business_subtitle.setError("Enter SubTitle");
                } else if (post.getText().toString().equals("")) {
                    post.setError("Enter Post");
                } else if (cnum.getText().toString().equals("")) {
                    cnum.setError("Enter ContactNumber");
                } else if (email.getText().toString().equals("")) {
                    email.setError("Enter Email");
                } else if (website.getText().toString().equals("")) {
                    website.setError("Enter Website");
                } else if (address.getText().toString().equals("")) {
                    address.setError("Enter Address");
                } else {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("status", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("fname", fname.getText().toString());
                    editor.putString("lname", lname.getText().toString());
                    editor.putString("title", business_title.getText().toString());
                    editor.putString("subtitle", business_subtitle.getText().toString());
                    editor.putString("post", post.getText().toString());
                    editor.putString("cnum", cnum.getText().toString());
                    editor.putString("email", email.getText().toString());
                    editor.putString("address", address.getText().toString());
                    editor.putString("website", website.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(ProfileActivity.this, GreenCardActivity.class);
                    startActivity(intent);
                }
            }
        });
        /*databaseHelper = new DatabaseHelper(this);*/


        toolbarLayout = findViewById(R.id.toolbar_layout);


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        toolbarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
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

  /*  public  void addData(String newEntry)
    {
        boolean insertdata =  databaseHelper.addData(newEntry);
        if (insertdata)
        {
            Toast.makeText(this, "inserted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "not inserted", Toast.LENGTH_SHORT).show();

        }
    }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            // imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            BitmapDrawable ob = new BitmapDrawable(getResources(), BitmapFactory.decodeFile(picturePath));
            imageView.setBackgroundDrawable(ob);
            fab.setImageDrawable(ob);

        }


    }
}


