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

public class MoActivity extends AppCompatActivity {

    final String myFileName="todo.txt";


    Button backBtnMo, saveBtnMo, deleteBtnMo;
    TextView tvW1, tvW1_1, tvW1_2, tvW2, tvW2_1, tvW2_2, tvW3, tvW3_1, tvW3_2, tvW4, tvW4_1, tvW4_2;
    private EditText etW1_1, etW1_2, etW2_1, etW2_2, etW3_1, etW3_2, etW4_1, etW4_2;
    CheckBox CBW1_1, CBW1_2, CBW2_1, CBW2_2, CBW3_1, CBW3_2, CBW4_1, CBW4_2;

    private String First, Second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo);
        getSupportActionBar().hide();

        backBtnMo = findViewById(R.id. backBtnMo);
        saveBtnMo = findViewById(R.id. saveBtnMo);
        deleteBtnMo = findViewById(R.id. deleteBtnMo);

        tvW1 = findViewById(R.id. tvW1);
        tvW1_1 = findViewById(R.id. tvW1_1);
        tvW1_2 = findViewById(R.id. tvW1_2);

        tvW2 = findViewById(R.id. tvW2);
        tvW2_1 = findViewById(R.id. tvW2_1);
        tvW2_2 = findViewById(R.id. tvW2_2);

        tvW3 = findViewById(R.id. tvW3);
        tvW3_1 = findViewById(R.id. tvW3_1);
        tvW3_2 = findViewById(R.id. tvW3_2);

        tvW4 = findViewById(R.id. tvW4);
        tvW4_1 = findViewById(R.id. tvW4_1);
        tvW4_2 = findViewById(R.id. tvW4_2);

        etW1_1 = findViewById(R.id. etW1_1);
        etW1_2 = findViewById(R.id. etW1_2);
        etW2_1 = findViewById(R.id. etW2_1);
        etW2_2 = findViewById(R.id. etW2_2);
        etW3_1 = findViewById(R.id. etW3_1);
        etW3_2 = findViewById(R.id. etW3_2);
        etW4_1 = findViewById(R.id. etW4_1);
        etW4_2 = findViewById(R.id. etW4_2);

        CBW1_1 = findViewById(R.id. CBW1_1);
        CBW1_2 = findViewById(R.id. CBW1_2);
        CBW2_1 = findViewById(R.id. CBW2_1);
        CBW2_2 = findViewById(R.id. CBW2_2);
        CBW3_1 = findViewById(R.id. CBW3_1);
        CBW3_2 = findViewById(R.id. CBW3_2);
        CBW4_1 = findViewById(R.id. CBW4_1);
        CBW4_2 = findViewById(R.id. CBW4_2);

        readToDoFromFile();
        displayToDo();
    }

    public void saveBtnMo_clicked(View v) {

        First = etW1_1.getText().toString();
        Second = etW1_2.getText().toString();

        First = etW2_1.getText().toString();
        Second = etW2_2.getText().toString();

        First = etW3_1.getText().toString();
        Second = etW3_2.getText().toString();

        First = etW4_1.getText().toString();
        Second = etW4_2.getText().toString();

        writeToDoToFile();

        Toast.makeText(this, "Daten gespeichert", Toast.LENGTH_SHORT).show();
    }

    public void deleteBtnMo_clicked (View v){
        First="";
        Second="";

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
        etW1_1.setText(First);
        etW1_2.setText(Second);

        etW2_1.setText(First);
        etW2_2.setText(Second);

        etW3_1.setText(First);
        etW3_2.setText(Second);

        etW4_1.setText(First);
        etW4_2.setText(Second);
    }


    public void backBtnMo_clicked(View view) {
        Intent startpIntent = new Intent(this, StartpActivity.class);
        startActivity(startpIntent);
    }
};