package com.ratnasrivastava.tableswithseekbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void generateTables(int number) {
        final ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int j = 1; j <= 10; j++) {
            arrayList.add(j - 1, new Integer(j * number));
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(10);
        //where the seekbar cursor will be
        seekBar.setProgress(1);
        //from where cursor will be started, if don't set, it would be started from 0
        seekBar.setMin(1);
        generateTables(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                generateTables(i);
                /*
               We can write content of generateTables here also , just we need to give context MainActivity.this

                 */

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}