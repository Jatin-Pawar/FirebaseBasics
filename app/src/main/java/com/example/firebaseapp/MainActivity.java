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

    EditText myKeyName, myKeyValue, myRoomName;
    Button myApplyBtn;
    String myKeyNameData, myKeyValueData, myRoomNameData;

    Firebase myFirebase;

    int i = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myKeyName = (EditText) findViewById(R.id.keyName);
        myKeyValue = (EditText) findViewById(R.id.keyValue);
        myRoomName = (EditText) findViewById(R.id.roomName);

        myApplyBtn = (Button) findViewById(R.id.button);





        Firebase.setAndroidContext(this);

        String DeviceId = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

//        myFirebase = new Firebase("https://fir-app-13aff.firebaseio.com/Users" + DeviceId);

        myApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRoomNameData = myRoomName.getText().toString();

                myFirebase = new Firebase("https://fir-app-13aff.firebaseio.com/" + myRoomNameData + "/Element_" + i);
                i=i+1;


                myKeyNameData = myKeyName.getText().toString();
                myKeyValueData = myKeyValue.getText().toString();
                Firebase myNewChild = myFirebase.child("Id");
                myNewChild.setValue(myKeyNameData);
                Firebase myNewChild_2 = myFirebase.child("Type");
                myNewChild_2.setValue(myKeyValueData);

                Toast.makeText(MainActivity.this,  myKeyNameData+" is updated with "+ myKeyValueData ,Toast.LENGTH_LONG).show();
            }
        });
    }
}
