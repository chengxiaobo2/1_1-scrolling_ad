package com.scrollad.cheng.scrollad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ScrollAdView adView;
    private ScrollWinAPrizeView scrollWinView;

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

        scrollWinView=(ScrollWinAPrizeView)findViewById(R.id.scrollwin);
        final List<String> listWin=new ArrayList<>();
        listWin.add("1。中奖了");
        listWin.add("2。中奖了");
        listWin.add("3。中奖了");
        listWin.add("4。中奖了");
        listWin.add("5。中奖了");
        listWin.add("6。中奖了");
        listWin.add("7。中奖了");
        listWin.add("8。中奖了");
        listWin.add("9。中奖了");
        listWin.add("10。中奖了");
        listWin.add("11。中奖了");
        listWin.add("12。中奖了");
        listWin.add("13。中奖了");
        listWin.add("14。中奖了");
        listWin.add("15。中奖了");
        listWin.add("16。中奖了");

        scrollWinView.post(new Runnable() {
            @Override
            public void run() {

                scrollWinView.initData(listWin,MainActivity.this);
            }
        });

        scrollWinView.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, (String)v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        scrollWinView.cancelAnimation();;
        adView.cancelAnimation();
    }
}
