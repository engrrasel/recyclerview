package com.example.horizontalscroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        Integer[] langLogo = {R.drawable.doa,R.drawable.fazayel,R.drawable.foroz_wazib,
                R.drawable.salat,R.drawable.more,R.drawable.hajj};

        String[] langName = {"Doa","Fazayel","Foroz Wazib","Salat","More","Hajj"};

        mainModels = new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
           MainModel model = new MainModel(langLogo[i],langName[i]);
           mainModels.add(model);

        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(MainActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);



    }
}
