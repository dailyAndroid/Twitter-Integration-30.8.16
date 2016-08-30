package com.example.hwhong.twitterintegration;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.Provider;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent is sending data from one activity to another, even across process boundaries.
                Intent intent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse("android.resource://com.example.hwhong.twitterintegration/*");

                try {
                    InputStream stream = getContentResolver().openInputStream(screenshotUri);
                }

                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                intent.setType("img/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                startActivity(Intent.createChooser(intent, "Sharing this on"));
            }
        });




    }
}
