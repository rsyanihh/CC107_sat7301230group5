package com.example.computeage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText  Lname;
    private TextView info;
    private Button login;
    private  EditText Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.etName);
        Lname = (EditText)findViewById(R.id.etLname);
        info = (TextView)findViewById(R.id.tvvi);
        login = (Button)findViewById(R.id.btnLogin);
        Age = (EditText) findViewById(R.id.etage);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String lname = Lname.getText().toString();
                String Myyear = Age.getText().toString().trim();

                int year = Calendar.getInstance().get(Calendar.YEAR);
                int y = year - Integer.parseInt(Age.getText().toString());


                if (Myyear.compareTo(String.valueOf(year)) > 0) {
                    Toast.makeText(MainActivity.this, name + " " + lname ,Toast.LENGTH_SHORT).show();
                }else if(y >18 ) {
                    info.setText(name + " " + lname + " " + y + "  Can Vote");
                    int yy = year - Integer.parseInt(Age.getText().toString());

                }else
                    info.setText(name + " " + lname + " " + y + "  Cannot Vote");


            }

        });
    }






}






