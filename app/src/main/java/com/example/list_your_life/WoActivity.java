package com.example.list_your_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WoActivity extends AppCompatActivity {

    final String myFileName = "todo.txt";

    Button backBtnW, saveBtnWo, deleteBtnWo;
    TextView tvMo, tvTue, tvWed, tvThur, tvFri, tvSat, tvSun, tvMo1, tvMo2, tvTue1, tvTue2, tvWed1, tvWed2, tvThur1, tvThur2, tvFri1, tvFri2, tvSat1, tvSat2, tvSun1, tvSun2;
    private EditText etMo1, etMo2, etTue1, etTue2, etWed1, etWed2, etThur1, etThur2, etFri1, etFri2, etSat1, etSat2, etSun1, etSun2;
    CheckBox CBMo1, CBMo2, CBTue1, CBTue2, CBWed1, CBWed2, CBThur1, CBThur2, CBFri1, CBFri2, CBSat1, CBSat2, CBSun1, CBSun2;

    private String First, Second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo);
        getSupportActionBar().hide();

        backBtnW = findViewById(R.id. backBtnW);
        saveBtnWo = findViewById(R.id. saveBtnWo);
        deleteBtnWo = findViewById(R.id. deleteBtnWo);

        tvMo = findViewById(R.id.tvMo);
        tvTue = findViewById(R.id.tvTue);
        tvWed = findViewById(R.id.tvWed);
        tvThur = findViewById(R.id.tvThur);
        tvFri=  findViewById(R.id.tvFri);
        tvSat = findViewById(R.id.tvSat);
        tvSun = findViewById(R.id. tvSun);

        tvMo1 = findViewById(R.id. tvMo1);
        tvMo2 = findViewById(R.id. tvMo2);
        tvTue1 = findViewById(R.id. tvTue1);
        tvTue2= findViewById(R.id. tvTue2);
        tvWed1= findViewById(R.id. tvWed1);
        tvWed2 = findViewById(R.id. tvWed2);
        tvThur1 = findViewById(R.id. tvThur1);
        tvThur2 = findViewById(R.id. tvThur2);
        tvFri1 = findViewById(R.id. tvFri1);
        tvFri2 = findViewById(R.id. tvFri2);
        tvSat1 = findViewById(R.id.tvSat1);
        tvSat2 = findViewById(R.id.tvSat2);
        tvSun1 = findViewById(R.id. tvSun1);
        tvSun2 = findViewById(R.id.tvSun2);

        etMo1 = findViewById(R.id.etMo1);
        etMo2 = findViewById(R.id.etMo2);
        etTue1 = findViewById(R.id.etTue1);
        etTue2 = findViewById(R.id.etTue2);
        etWed1 = findViewById(R.id.etWed1);
        etWed2 = findViewById(R.id.etWed2);
        etThur1 = findViewById(R.id.etThur1);
        etThur2 = findViewById(R.id.etThur2);
        etFri1 = findViewById(R.id.etFri1);
        etFri2 = findViewById(R.id.etFri2);
        etSat1 = findViewById(R.id. etSat1);
        etSat2 = findViewById(R.id. etSat2);
        etSun1 = findViewById(R.id.etSun1);
        etSun2 = findViewById(R.id. etSun2);

        CBMo1 = findViewById(R.id.CBMo1);
        CBMo2 = findViewById(R.id.CBMo2);
        CBTue1 = findViewById(R.id.CBTue1);
        CBTue2 = findViewById(R.id.CBTue2);
        CBWed1 = findViewById(R.id.CBWed1);
        CBWed2 = findViewById(R.id.CBWed2);
        CBThur1 = findViewById(R.id.CBThur1);
        CBThur2 = findViewById(R.id.CBThur2);
        CBFri1 = findViewById(R.id.CBFri1);
        CBFri2 = findViewById(R.id.CBFri2);
        CBSat1 = findViewById(R.id. CBSat1);
        CBSat2 = findViewById(R.id. CBSat2);
        CBSun1 = findViewById(R.id. CBSun1);
        CBSun2 =findViewById(R.id. CBSun2);

        readToDoFromFile();
        displayToDo();
    }

    public void deleteBtnWo_clicked (View v){
        First="";
        Second="";

        writeToDoToFile();
        displayToDo();
        Toast.makeText(this, "Daten gelöscht", Toast.LENGTH_SHORT).show();

    }

    public void saveBtnWo_clicked (View v) {
        First = etMo1.getText().toString();
        Second = etMo2.getText().toString();

        First= etTue1.getText().toString();
        Second =etTue2.getText().toString();

        First = etWed1.getText().toString();
        Second = etWed2.getText().toString();

        First = etThur1.getText().toString();
        Second = etThur2.getText().toString();

        First = etFri1.getText().toString();
        Second = etFri2.getText().toString();

        First = etSat1.getText().toString();
        Second = etSat2.getText().toString();

        First = etSun1.getText().toString();
        Second = etSun2.getText().toString();

        writeToDoToFile();

        Toast.makeText(this, "Daten gespeichert", Toast.LENGTH_SHORT).show();
    }

    public void readToDoFromFile() {
        try {
            FileInputStream myInputStream = openFileInput(myFileName);
            InputStreamReader myInputStreamReader = new InputStreamReader(myInputStream);
            BufferedReader myBufferedReader = new BufferedReader(myInputStreamReader);
            First = myBufferedReader.readLine();
            Second = myBufferedReader.readLine();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Fehler:Datei nicht gefunden", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this, "Fehler beim Lesen der Daten", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void writeToDoToFile() {
        File ToDoFile;
        try {
            FileInputStream myInputStream = openFileInput(myFileName);
        } catch (FileNotFoundException e) {
            ToDoFile = new File(getFilesDir(), myFileName);
            Toast.makeText(this, "To-Do-Datei" + myFileName + "wurde neu angelegt", Toast.LENGTH_SHORT).show();
        }
        try {
            ToDoFile = new File(getFilesDir(), myFileName);
            FileOutputStream myFileOutputStream = new FileOutputStream(ToDoFile);
            OutputStreamWriter myOutputStreamWriter = new OutputStreamWriter(myFileOutputStream);
            BufferedWriter myBufferedWriter = new BufferedWriter(myOutputStreamWriter);

            myBufferedWriter.write(First);
            myBufferedWriter.newLine();

            myBufferedWriter.write(Second);
            myBufferedWriter.newLine();

            myBufferedWriter.flush();
            myBufferedWriter.close();
            Toast.makeText(this, "Datei erfolgreich gespeichert", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void displayToDo(){
            etMo1.setText(First);
            etMo2.setText(Second);

            etTue1.setText(First);
            etTue2.setText(Second);

            etWed1.setText(First);
            etWed2.setText(Second);

            etThur1.setText(First);
            etThur2.setText(Second);

            etFri1.setText(First);
            etFri2.setText(Second);

            etSat1.setText(First);
            etSat2.setText(Second);

            etSun1.setText(First);
            etSun2.setText(Second);
        }


        public void backBtnW_clicked (View view){
            Intent startpIntent = new Intent(this, StartpActivity.class);
            startActivity(startpIntent);
        }
    }