package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle image = getIntent().getExtras();
        ImageView imageView = findViewById(R.id.image);
        int imageResource = image.getInt("image");
        imageView.setImageResource(imageResource);

    }
}