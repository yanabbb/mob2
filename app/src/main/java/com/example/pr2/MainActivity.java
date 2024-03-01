package com.example.pr2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
        TextView textView = findViewById(R.id.main_text);
        textView.setText(getString(R.string.relative_l));
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(R.drawable.img1);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", R.drawable.img2);
                start.launch(intent);
                //Log.d("MyTag", "Кнопка была нажата!");
            }

            ActivityResultLauncher<Intent> start = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Bundle image = result.getData().getExtras();
                            ImageView imageView = findViewById(R.id.image);
                            int imageResource = image.getInt("image");
                            imageView.setImageResource(imageResource);
                        }
                    });
        });
    }
    /*public void onClick(View view) {
        Log.d("CLICK_TAG", "The button is pressed");
    }*/
}