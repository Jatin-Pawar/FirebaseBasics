package com.example.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    EditText myEditText;
    Button myApplyBtn;
    String myStringData;

    Firebase myFirebase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = (EditText) findViewById(R.id.editText);
        myApplyBtn = (Button) findViewById(R.id.button);

        myStringData = myEditText.getText().toString();

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://fir-app-13aff.firebaseio.com");
    }
}
