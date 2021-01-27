package com.example.list_your_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startBtn;
    TextView tv1, tv2;
    ImageView iVlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_List_your_Life);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        startBtn = findViewById(R.id.startBtn);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        iVlogo = findViewById(R.id. iVlogo);
    }

    public void startBtn_clicked(View view) {
        Intent startpIntent =new Intent (this, StartpActivity.class);
        startActivity(startpIntent);
    }
}