package com.example.a201b062;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SharedPreferences sharedPreferences;
    String []winnersArray={"devansh","arpit","shriansh"};
    public void storePreference(View view){
        sharedPreferences.edit().putString("player",new Gson().toJson(winnersArray)).apply();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPreferences=this.getSharedPreferences("com.example.a201b062",0);
        String[] temp=new Gson().fromJson(sharedPreferences.getString("player",null),winnersArray.getClass());
        textView.setText(Arrays.toString(temp));
    }
}