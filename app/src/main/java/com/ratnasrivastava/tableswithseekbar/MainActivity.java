package com.ratnasrivastava.tableswithseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setMax(10);
        seekBar.setMin(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ListView listView = (ListView) findViewById(R.id.list_view);
                final ArrayList<Integer> arrayList = new ArrayList<Integer>();
                //If you want to set at particular index, then first u need to initialize
//                for(int j=0;j<10;j++){
//                    arrayList.add(0);
//                }
                for(int j=1;j<=10;j++){
                    arrayList.add(j-1, new Integer(j*i));
                }
                ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(arrayAdapter);
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