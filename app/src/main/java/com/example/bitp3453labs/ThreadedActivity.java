package com.example.bitp3453labs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends AppCompatActivity {

    ImageView iv;
    TextView greeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threaded);

        iv = findViewById(R.id.ivPicture);
        Intent intent = getIntent();
        String strName = intent.getStringExtra("varName");
        Integer intAge = intent.getIntExtra("varAge", 0);

        greeting = findViewById(R.id.tvGreeting);
        greeting.setText("Welcome to new activity, " + strName + "!");
    }

    public void fnTakePic(View vw)
    {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        greeting.setText(greeting.getText().toString() + "\n" + "Successfully took your picture! :)");
                    }
                });
            }
        };

        Thread thr = new Thread(run);
        thr.start();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);

    }
}
