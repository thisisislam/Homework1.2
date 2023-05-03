package com.example.homework12;

import static android.Manifest.permission.CALL_PHONE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.homework12.R;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private String phoneNumber;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView=findViewById(R.id.text_view);
        button=findViewById(R.id.call_btn);

        Intent intent =getIntent();
        phoneNumber=intent.getStringExtra("phone_number");
        textView.setText(phoneNumber);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            requestPermissions(new String[]{CALL_PHONE}, 1);
        }

        button.setOnClickListener(view -> {
            String phoneNumber=textView.getText().toString();
            Intent intent1=new Intent(Intent.ACTION_CALL);
            intent1.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(intent1);
        });


    }
}

