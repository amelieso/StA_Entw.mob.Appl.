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

public class HeutActivity extends AppCompatActivity {

    final String myFileName= "todo.txt";

    Button backBtn, saveBtn, deleteBtn;
    TextView tvA, tvB, tvC, tvA1, tvA2, tvA3, tvA4, tvA5, tvB1, tvB2, tvB3, tvB4, tvB5, tvC1, tvC2, tvC3, tvC4, tvC5;
    private EditText etA1, etA2, etA3, etA4,etA5, etB1, etB2, etB3, etB4, etB5, etC1, etC2, etC3, etC4, etC5;
    CheckBox chA1,chA2, chA3, chA4, chA5, chB1, chB2, chB3, chB4, chB5, chC1, chC2, chC3, chC4, chC5;

    private String First, Second, Third, Fourth, Fifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heut);
        getSupportActionBar().hide();

        backBtn = findViewById(R.id.backBtnMo);
        saveBtn = findViewById(R.id. saveBtn);
        deleteBtn = findViewById(R.id.deleteBtn);

        tvA = findViewById(R.id.tvA);
        tvB = findViewById(R.id.tvB);
        tvC = findViewById(R.id. tvC);

        tvA1 = findViewById(R.id. tvA1);
        tvA2 = findViewById(R.id. tvA2);
        tvA3 = findViewById(R.id. tvA3);
        tvA4 = findViewById(R.id. tvA4);
        tvA5 = findViewById(R.id. tvA5);

        tvB1 = findViewById(R.id. tvB1);
        tvB2 = findViewById(R.id. tvB2);
        tvB3 = findViewById(R.id. tvB3);
        tvB4 = findViewById(R.id. tvB4);
        tvB5 = findViewById(R.id. tvB5);

        tvC1 = findViewById(R.id. tvC1);
        tvC2 = findViewById(R.id. tvC2);
        tvC3 = findViewById(R.id. tvC3);
        tvC4 = findViewById(R.id. tvC4);
        tvC5 = findViewById(R.id. tvC5);

        etA1 =findViewById(R.id. etA1);
        etA2 =findViewById(R.id. etA2);
        etA3 =findViewById(R.id. etA3);
        etA4 =findViewById(R.id. etA4);
        etA5 =findViewById(R.id. etA5);

        etB1 = findViewById(R.id. etB1);
        etB2 = findViewById(R.id. etB2);
        etB3 = findViewById(R.id. etB3);
        etB4 = findViewById(R.id. etB4);
        etB5 = findViewById(R.id. etB5);

        etC1 = findViewById(R.id.etC1);
        etC2 = findViewById(R.id.etC2);
        etC3 = findViewById(R.id.etC3);
        etC4 = findViewById(R.id.etC4);
        etC5 = findViewById(R.id.etC5);

        chA1 = findViewById(R.id.chA1);
        chA2 = findViewById(R.id.chA2);
        chA3 = findViewById(R.id.chA3);
        chA4 = findViewById(R.id.chA4);
        chA5 = findViewById(R.id.chA5);

        chB1 = findViewById(R.id.chB1);
        chB2 = findViewById(R.id.chB2);
        chB3 = findViewById(R.id.chB3);
        chB4 = findViewById(R.id.chB4);
        chB5 = findViewById(R.id.chB5);

        chC1 = findViewById(R.id.chC1);
        chC2 = findViewById(R.id.chC2);
        chC3 = findViewById(R.id.chC3);
        chC4 = findViewById(R.id.chC4);
        chC5 = findViewById(R.id.chC5);

        readToDoFromFile();
        displayToDo();
    }

    public void saveBtn_clicked (View v) {

       First = etA1.getText().toString();
       Second = etA2.getText().toString();
       Third = etA3.getText().toString();
       Fourth = etA4.getText().toString();
       Fifth = etA5.getText().toString();

       First = etB1.getText().toString();
       Second = etB2.getText().toString();
       Third = etB3.getText().toString();
       Fourth = etB4.getText().toString();
       Fifth = etB5.getText().toString();

        First = etC1.getText().toString();
        Second = etC2.getText().toString();
        Third = etC3.getText().toString();
        Fourth = etC4.getText().toString();
        Fifth = etC5.getText().toString();


        writeToDoToFile();


       Toast.makeText(this, "Daten gespeichert", Toast.LENGTH_SHORT).show();
    }

    public void deleteBtn_clicked (View v){
        First="";
        Second="";
        Third="";
        Fourth="";
        Fifth="";

        writeToDoToFile();
        displayToDo();
        Toast.makeText(this, "Daten gelöscht", Toast.LENGTH_SHORT).show();

    }

    public void readToDoFromFile() {
        try {
            FileInputStream myInputStream = openFileInput(myFileName);
            InputStreamReader myInputStreamReader = new InputStreamReader(myInputStream);
            BufferedReader myBufferedReader = new BufferedReader(myInputStreamReader);
            First = myBufferedReader.readLine();
            Second = myBufferedReader.readLine();
            Third = myBufferedReader.readLine();
            Fourth = myBufferedReader.readLine();
            Fifth = myBufferedReader.readLine();

        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Fehler:Datei nicht gefunden", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this, "Fehler beim Lesen der Daten", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void writeToDoToFile(){
        File ToDoFile;
        try{
            FileInputStream myInputStream = openFileInput(myFileName);
        } catch (FileNotFoundException e) {
            ToDoFile = new File(getFilesDir(), myFileName);
            Toast.makeText(this, "To-Do-Datei" + myFileName + "wurde neu angelegt", Toast.LENGTH_SHORT).show();
        }
        try {
            ToDoFile = new File(getFilesDir(), myFileName);
            FileOutputStream myFileOutputStream = new FileOutputStream(ToDoFile);
            OutputStreamWriter myOutputStreamWriter = new OutputStreamWriter(myFileOutputStream);
            BufferedWriter myBufferedWriter = new BufferedWriter (myOutputStreamWriter);

            myBufferedWriter.write(First);
            myBufferedWriter.newLine();

            myBufferedWriter. write(Second);
            myBufferedWriter.newLine();

            myBufferedWriter. write(Third);
            myBufferedWriter.newLine();

            myBufferedWriter. write(Fourth);
            myBufferedWriter.newLine();

            myBufferedWriter. write(Fifth);
            myBufferedWriter.newLine();

            myBufferedWriter.flush();
            myBufferedWriter.close();
            Toast.makeText(this, "Datei erfolgreich gespeichert", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayToDo(){
        etA1.setText(First);
        etA2.setText(Second);
        etA3.setText(Third);
        etA4.setText(Fourth);
        etA5.setText(Fifth);

        etB1.setText(First);
        etB2.setText(Second);
        etB3.setText(Third);
        etB4.setText(Fourth);
        etB5.setText(Fifth);

        etC1.setText(First);
        etC2.setText(Second);
        etC3.setText(Third);
        etC4.setText(Fourth);
        etC5.setText(Fifth);
    }

    public void backBtn_clicked(View view) {
        Intent startpIntent = new Intent(this, StartpActivity.class);
        startActivity(startpIntent);
    }
}
