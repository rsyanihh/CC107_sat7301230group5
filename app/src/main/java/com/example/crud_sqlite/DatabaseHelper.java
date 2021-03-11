package com.example.crud_sqlite;


    import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class DatabaseHelper  extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "student.db";
        public static final String Table_Name = "student_table";
        public static final String Col_1 = "ID";
        public static final String Col_2 = "NAME";
        public static final String Col_3 = "SURNAME";
        public static final String Col_4 = "MARK";


        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + Table_Name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT,SURNAME TEXT,MARK INTEGER)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
            onCreate(db);

        }

        public boolean insertData(String name , String surname, String marks){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValue = new ContentValues();
            contentValue.put(Col_2, name);
            contentValue.put(Col_3, surname);
            contentValue.put(Col_4, marks);


            long result = db.insert(Table_Name,null,contentValue);
            if(result ==  -1)
                return false;
            else
                return true;

        }
        public Cursor getAllDAta(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from "+ Table_Name,null);
            return  res;


        }

        public  boolean UpdateData(String id , String name , String surname , String marks){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Col_1,id);
            contentValues.put(Col_2,name);
            contentValues.put(Col_3,surname);
            contentValues.put(Col_4,marks);
            db.update(Table_Name, contentValues,"ID = ?",new String[]{id});
            return true;

        }
        public Integer DeleteData (String id){
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(Table_Name, "ID = ?", new String[] {id});

        }
    }


