package com.example.android_v2_news_card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private Adapter adapter;
//    private ArrayList<String> items;


    //Вариант 2 с классом классом NewsItems
    private ArrayList<NewsItems> items= new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterForNewsItems adapterForNewsItems;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //версия без класса NewsItems, переменные получаются из встроенного класса data

//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        // создаем адаптер
//        adapter = new Adapter(this,items);  //item это как бы данные указанных переменных
//        // устанавливаем для списка адаптер
//        recyclerView.setAdapter(adapter);
//        items = new ArrayList<>();
//        items.add("First CardView Item");
//        items.add("Second CardView Item");


        //Вариант 2 с классом классом NewsItems
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // создаем адаптер
        adapterForNewsItems = new AdapterForNewsItems(this, items);  //item это как бы данные указанных переменных
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapterForNewsItems);

        //дополнение мои статическая БД от класса NewsItems
        {
            items.add(new NewsItems(
                    "Podcast 256: You down with GPT-3? Yeah you know me!",
                    "Just tell the nice AI what you want to see, and watch the code magically appear... The post Podcast 256: You down with GPT-3? Yeah you know me! appeared first on Stack Overflow Blog.",
                     R.drawable.img2
            ));
            items.add(new NewsItems(
                    "Brian Gilmartin, CFA",
                    "CME Earnings Preview: Long-Time Outperformer, Now Lagging Badly Given Interest-Rate Volatility",
                     R.drawable.img1
            ));
            items.add(new NewsItems(
                    "Cointelegraph By Turner Wright",
                    "Developers released the validator launchpad for ETH 2.0 on July 27, allowing users to participate in the testnet’s Proof-of-Stake.",
                     R.drawable.img3
            ));
        }
    }
}