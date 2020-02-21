package com.example.firstmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.firstmodule.activities.NormalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(NormalActivity.getStartIntent(this,0));

    }


}
