package com.example.phone;

import static com.example.phone.R.id.callbtn;
import static com.example.phone.R.layout.activity_main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText phoneNo;
    FloatingActionButton callbtn;
    static int PERMISSION_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNo = findViewById(R.id.editTextPhone);
        callbtn = findViewById(R.id.callbtn);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
    callbtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String phoneno=phoneNo.getText().toString();
            Intent i=new Intent(Intent.ACTION_CALL);
            i.setData(Uri.parse("tel:"+phoneno));
            startActivity(i);

        }
    });



    }
}



