package com.example.module9assignment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        textView = findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedItem = extras.getString("selectedItem");
            textView.setText("You clicked " + selectedItem);
        }
    }
}