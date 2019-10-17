package com.shanker.cab;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_demo);


        //for single preferences

        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);

        //for multiple preferences

        SharedPreferences preferences1 = getSharedPreferences("fileName",Context.MODE_PRIVATE);

        //write data to preference object
        SharedPreferences.Editor editor = preferences1.edit();
        editor.putBoolean("isopened first time" , true);
        editor.putString("key","value");
        editor.putInt("intkey",1);
        editor.putFloat("floatkey",10);
        editor.putLong("longkey",10000);
        editor.putLong("longkey",500); //modify values
        editor.apply();

        //remove values
        editor.remove("longkey");
        editor.apply();

        //remove everything
        editor.clear();
        editor.apply();
        //read data from file shared preference

        preferences1.getString("key",null);
        preferences1.getInt("intkey",0);
        preferences1.getFloat("floatkey",0);
        preferences1.getBoolean("is opened first time", false);
        preferences1.getLong("longkey",0);
    }
}
