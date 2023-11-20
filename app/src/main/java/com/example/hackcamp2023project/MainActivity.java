package com.example.hackcamp2023project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> logs;
    private ArrayAdapter<String> logsAdapter;
    private ListView listView;
    private Button button;
    private Button navigationButton;
    private Button accountButton;
    private SeekBar seekBar;
    private TextInputEditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button16);
        navigationButton = findViewById(R.id.navigationButton);
        accountButton = findViewById(R.id.profileButton);
        seekBar = findViewById(R.id.seekBar);
        text = findViewById(R.id.textInputEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });

        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Map.class);
                startActivity(intent);
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Account.class);
                startActivity(intent);
            }
        });

        logs = new ArrayList<>();
        logsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logs);
        listView.setAdapter(logsAdapter);
        // setUpListViewListener();

    }

//    private void setUpListViewListener() {
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Context context = getApplicationContext();
//                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();
//
//                logs.remove(position);
//                logsAdapter.notifyDataSetChanged();
//                return true;
//            }
//
//        });
//    }

    private void addItem(View v) {
        String rating = Integer.toString(seekBar.getProgress());
        String desc = text.getText().toString();
        String star = "☆";
        String print = desc + " " + star.repeat(seekBar.getProgress());

        if(!(desc.equals(""))) {
            logsAdapter.add(print);
            text.setText("");
        } else {
            ///
        }
    }
}