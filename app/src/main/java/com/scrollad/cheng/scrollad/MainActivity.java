package com.scrollad.cheng.scrollad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ScrollAdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView=(ScrollAdView)findViewById(R.id.scrollad);

        final List<String> list=new ArrayList<>();
        list.add("1。促销买买买");
        list.add("2。促销买买买");
        list.add("3。促销买买买");
        list.add("4。促销买买买");
        list.add("5。促销买买买");
        list.add("6。促销买买买");
        list.add("7。促销买买买");
        list.add("8。促销买买买");
        list.add("9。促销买买买");


        adView.post(new Runnable() {
            @Override
            public void run() {

                adView.initData(list,MainActivity.this);
            }
        });

        adView.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, (String)v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
