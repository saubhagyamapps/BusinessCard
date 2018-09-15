package com.example.android.businesscard.Activity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.businesscard.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.sql.Types.NULL;

public class RedCardActivity extends AppCompatActivity {
    private static final String TAG = "GreenCardActivity";
    TextView name, setpost, edt_email, edt_cnum, edt_website, edt_address, edt_title, edt_subtitle;
    String newString;
    Typeface font;
    File file;
    File folder;
    String root;
    Bitmap bitmap;
    CardView linearLayout;
    CardView img;
    String timeStamp;

    Button download1,share1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_card);
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.red_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        share1 = findViewById(R.id.sharered);
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        download1 = findViewById(R.id.download);
        download1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bitmap = getBitmap(linearLayout);
                saveChart(bitmap, linearLayout.getMeasuredHeight(), linearLayout.getMeasuredWidth(),img);
            }
        });
        Bundle extras = getIntent().getExtras();
        newString = extras.getString("font");
        name = findViewById(R.id.rname);
        setpost = findViewById(R.id.rpost);
        edt_email = findViewById(R.id.remail);
        edt_cnum = findViewById(R.id.rcnum);
        edt_website = findViewById(R.id.rwebsite);
        edt_address = findViewById(R.id.raddress);
        edt_title = findViewById(R.id.rtitle);
        edt_subtitle = findViewById(R.id.rsubtitle);
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
        font = Typeface.createFromAsset(getAssets(), "fonts/" + newString);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public Bitmap getBitmap(CardView layout) {
        layout.setDrawingCacheEnabled(true);
        layout.buildDrawingCache();
        Bitmap bmp = Bitmap.createBitmap(layout.getDrawingCache());
        layout.setDrawingCacheEnabled(false);
        return bmp;
    }
    private void saveChart(Bitmap getbitmap, float height, float width, CardView img) {

        root = Environment.getExternalStorageDirectory().toString();
        folder = new File(root + "/Card");
        boolean success = false;

        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss",
                Locale.getDefault()).format(new Date());
        file = new File(folder.getPath() + File.separator + img + ".png");

        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream ostream = null;

        try {
            ostream = new FileOutputStream(file);
            System.out.println(ostream);
            Bitmap well = getbitmap;
            Bitmap save = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            Canvas now = new Canvas(save);
            now.drawRect(new Rect(0, 0, (int) width, (int) height), paint);
            now.drawBitmap(well,
                    new Rect(0, 0, well.getWidth(), well.getHeight()),
                    new Rect(0, 0, (int) width, (int) height), null);

            if (save == null) {
                System.out.println(NULL);
            }
            save.compress(Bitmap.CompressFormat.PNG, 100, ostream);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
