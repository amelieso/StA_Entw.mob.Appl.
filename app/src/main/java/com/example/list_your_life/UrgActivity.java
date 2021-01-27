package com.example.list_your_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
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

public class UrgActivity extends AppCompatActivity {

    final String myFileName = "todo.txt";

    Button backBtnUrg, saveBtnUrg, deleteBtnUrg;
    TextView tvFir, tvETF, tvUrTD, tvUrg1, tvUrg2, tvUrg3, tvUrg4, tvUrg5, tvYCDI;
   private  EditText etUrg1, etUrg2, etUrg3, etUrg4, etUrg5;
    CheckBox CBUrg1, CBUrg2, CBUrg3, CBUrg4, CBUrg5;
    ImageView iVlogo2;

    private String First, Second, Third, Fourth, Fifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urg);
        getSupportActionBar().hide();

        backBtnUrg = findViewById(R.id.backBtnUrg);
        saveBtnUrg = findViewById(R.id.saveBtnUrg);
        deleteBtnUrg = findViewById(R.id. deleteBtnUrg);

        tvFir = findViewById(R.id.tvFir);
        tvETF = findViewById(R.id.tvETF);
        tvUrTD = findViewById(R.id.tvUrTD);
        tvUrg1 = findViewById(R.id.tvUrg1);
        tvUrg2 = findViewById(R.id.tvUrg2);
        tvUrg3 = findViewById(R.id.tvUrg3);
        tvUrg4 = findViewById(R.id.tvUrg4);
        tvUrg5 = findViewById(R.id.tvUrg5);
        tvYCDI = findViewById(R.id.tvYCDI);

        etUrg1 = findViewById(R.id.etUrg1);
        etUrg2 = findViewById(R.id.etUrg2);
        etUrg3 = findViewById(R.id.etUrg3);
        etUrg4 = findViewById(R.id.etUrg4);
        etUrg5 = findViewById(R.id.etUrg5);

        CBUrg1 = findViewById(R.id.CBUrg1);
        CBUrg2 = findViewById(R.id.CBUrg2);
        CBUrg3 = findViewById(R.id.CBUrg3);
        CBUrg4 = findViewById(R.id.CBUrg4);
        CBUrg5 = findViewById(R.id.CBUrg5);

        iVlogo2 = findViewById(R.id. iVlogo2);

        readToDoFromFile();
        displayToDo();
    }

    public void setSaveBtnUrg_clicked(View v) {
        First = etUrg1.getText().toString();
        Second = etUrg2.getText().toString();
        Third = etUrg3.getText().toString();
        Fourth = etUrg4.getText().toString();
        Fifth = etUrg5.getText().toString();

        writeToDoToFile();

        Toast.makeText(this, "Daten gespeichert", Toast.LENGTH_SHORT).show();
    }

    public void deleteBtnUrg_clicked (View view){
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

            myBufferedWriter.write(Third);
            myBufferedWriter.newLine();

            myBufferedWriter.write(Fourth);
            myBufferedWriter.newLine();

            myBufferedWriter.write(Fifth);
            myBufferedWriter.newLine();


            myBufferedWriter.flush();
            myBufferedWriter.close();
            Toast.makeText(this, "Datei erfolgreich gespeichert", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayToDo() {

        etUrg1.setText(First);
        etUrg2.setText(Second);
        etUrg3.setText(Third);
        etUrg4.setText(Fourth);
        etUrg5.setText(Fifth);
    }

    public void backBtnUrg_clicked(View view) {
        Intent startpIntent = new Intent(this, StartpActivity.class);
        startActivity(startpIntent);
    }
}
