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
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.businesscard.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.sql.Types.NULL;

public class GreenCardActivity extends AppCompatActivity {
    TextView name, setpost, edt_email, edt_cnum, edt_website, edt_address, edt_title, edt_subtitle;
    private static final String TAG = "GreenCardActivity";
    String newString;
    RelativeLayout relative;
    Typeface font;
    File folder;
    File file;
    String root;
    Bitmap bitmap;
    CardView linearLayout,card;
    Button download;
    CardView img;
    String timeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_card);
        download = findViewById(R.id.download);
        linearLayout = findViewById(R.id.card);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bitmap = getBitmap(linearLayout);
                saveChart(bitmap, linearLayout.getMeasuredHeight(), linearLayout.getMeasuredWidth(),img);
            }
        });
        relative = findViewById(R.id.relative);

        Bundle extras = getIntent().getExtras();

        newString = extras.getString("font");
        Log.e(TAG, "hiiiiii: " + newString);


        name = findViewById(R.id.name);
        setpost = findViewById(R.id.post);
        edt_email = findViewById(R.id.email);
        edt_cnum = findViewById(R.id.cnum);
        edt_website = findViewById(R.id.website);
        edt_address = findViewById(R.id.address);
        edt_title = findViewById(R.id.title);
        edt_subtitle = findViewById(R.id.subtitle);

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
