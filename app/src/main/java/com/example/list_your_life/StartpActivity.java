package com.example.list_your_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class StartpActivity extends AppCompatActivity {

    TextView tvWel;
    CalendarView calendar;
    Button heutBtn, WoBtn, MoBtn, WiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startp);
        getSupportActionBar().hide();


        heutBtn = findViewById(R.id.heutBtn);
        WoBtn = findViewById(R.id. WoBtn);
        MoBtn = findViewById(R.id.MoBtn);
        WiBtn = findViewById(R.id.UrgBtn);

        tvWel = findViewById(R.id.tvWel);
        calendar = findViewById(R.id.calendar);
    }

    public void heutBtn_clicked(View view) {
        Intent heutIntent = new Intent(this, HeutActivity.class);
        startActivity(heutIntent);
    }

    public void WoBtn_clicked (View view) {
        Intent woIntent= new Intent (this, WoActivity.class);
        startActivity(woIntent);
    }

    public void MoBtn_clicked(View view) {
        Intent MoIntent = new Intent(this, MoActivity.class);
        startActivity(MoIntent);
    }

    public void UrgBtn_clicked(View view) {
        Intent UrgIntent = new Intent(this, UrgActivity.class);
        startActivity(UrgIntent);
    }
}