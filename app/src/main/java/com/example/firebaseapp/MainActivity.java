package com.example.firebaseapp;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    EditText myEditText, myKeyValue;
    Button myApplyBtn;
    String myStringData, myKeyValueData;

    Firebase myFirebase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = (EditText) findViewById(R.id.editText);
        myKeyValue = (EditText) findViewById(R.id.editText2);

        myApplyBtn = (Button) findViewById(R.id.button);



        Firebase.setAndroidContext(this);

        String DeviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        myFirebase = new Firebase("https://fir-app-13aff.firebaseio.com/Users" + DeviceId);

        myApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myStringData = myEditText.getText().toString();
                myKeyValueData = myKeyValue.getText().toString();
                Firebase myNewChild = myFirebase.child(myKeyValueData);
                myNewChild.setValue(myStringData);

                Toast.makeText(MainActivity.this, myKeyValueData +" is updated with "+ myStringData ,Toast.LENGTH_LONG).show();
            }
        });
    }
}
