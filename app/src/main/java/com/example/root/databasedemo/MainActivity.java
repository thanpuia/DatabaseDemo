package com.example.root.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            //TABLE WITHOUT PRIMARY KEY
           /// myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            //TABLE WITH PRIMARY KEY
           myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

       //     myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Rob', 34)");
        //    myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Tommy', 77)");

//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Rob', 34)");
//            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Tommy', 77)");
            //UPDATE
            // myDatabase.execSQL("UPDATE users SET age = 2 WHERE name = 'Rob' LIMIT 1");

            //DELETE
            //myDatabase.execSQL("DELETE FROM users WHERE name = 'Rob' LIMIT 1");

            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            //QUERY WITH FILTERS
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'K%'", null);


            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while (c!= null) {

                Log.i("name", c.getString(nameIndex));
                Log.i("name", c.getString(ageIndex));
                c.moveToNext();
            }

        }
        catch ( Exception e) {

            e.printStackTrace();
        }
    }
}
