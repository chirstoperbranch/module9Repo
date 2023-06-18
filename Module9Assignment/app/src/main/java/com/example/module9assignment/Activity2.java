package com.example.module9assignment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Activity2 extends AppCompatActivity {
    private ListView listView;
    private Handler handler;
    private Timer timer;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        listView = findViewById(R.id.listView);
        handler = new Handler();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            number = Integer.parseInt(extras.getString("number"));
        }

        generateListAsync(number);
    }

    private void generateListAsync(int number) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<String> itemList = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    itemList.add("Item " + i);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                Activity2.this,
                                android.R.layout.simple_list_item_1,
                                itemList
                        );
                        listView.setAdapter(adapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String selectedItem = (String) parent.getItemAtPosition(position);
                                Intent intent = new Intent(Activity2.this, Activity3.class);
                                intent.putExtra("selectedItem", selectedItem);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        }, 1000);
    }
}