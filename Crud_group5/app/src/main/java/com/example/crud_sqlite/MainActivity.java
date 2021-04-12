package com.example.crud_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText Nanme;
    EditText edittextforID;
    EditText surname ;
    EditText Marks;
    Button Bbutton ;
    Button ButtonV;
    Button ButtonU;
    Button ButoonD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        edittextforID = (EditText)findViewById(R.id.etid);
        Marks = (EditText)findViewById(R.id.mks);
        Nanme = (EditText)findViewById(R.id.n);
        surname = (EditText)findViewById(R.id.s);
        Bbutton = (Button)findViewById(R.id.buttonA);
        ButtonV =(Button)findViewById(R.id.buttonR) ;
        ButtonU =(Button)findViewById(R.id.buttonU) ;
        ButoonD =(Button)findViewById(R.id.buttonD);
        AddData();
        viewAll();
        Update();
        Delete();

    }
    public void Delete(){
        ButoonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer delete = myDb.DeleteData(edittextforID.getText().toString());
                if (delete > 0)
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void Update(){
        ButtonU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean update = myDb.UpdateData(edittextforID.getText().toString(),Nanme.getText().toString(),
                        surname.getText().toString(),
                        Marks.getText().toString());
                if(update == true)
                    Toast.makeText(MainActivity.this,"Data Updates",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Updates",Toast.LENGTH_LONG).show();


            }
        });

    }
    public void AddData(){
        Bbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(Nanme.getText().toString(), surname.getText().toString(),Marks.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"notInserted",Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    public void viewAll(){
        ButtonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllDAta();
                if(res.getCount() == 0){
                    showMessage("Erorr","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append("Marks :"+ res.getString(3)+"\n\n");
                }
                //show all data
                showMessage("Data",buffer.toString());

            }
        });


    }


    public void showMessage(String tile, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tile);
        builder.setMessage(Message);
        builder.show();
    }
}