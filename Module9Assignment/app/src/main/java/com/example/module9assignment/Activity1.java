package com.example.module9assignment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    private EditText numberEditText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        numberEditText = findViewById(R.id.numberEditText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = numberEditText.getText().toString();

                Intent intent = new Intent(Activity1.this, Activity2.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });
    }
}
