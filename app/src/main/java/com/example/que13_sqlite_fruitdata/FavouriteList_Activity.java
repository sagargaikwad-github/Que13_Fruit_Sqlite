package com.example.que13_sqlite_fruitdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FavouriteList_Activity extends AppCompatActivity implements DeleteDataInterface{
    RecyclerView recyclerView;
    TextView no_data_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);
        recyclerView=findViewById(R.id.recyclerview_favourite);
        no_data_tv=findViewById(R.id.no_data_found);

         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setTitle("Favourite Fruits");



        DBManager dbManager=new DBManager(FavouriteList_Activity.this);
        ArrayList<FruitData> newlist=dbManager.fav_list();

        if(newlist.isEmpty() || dbManager.fav_list()==null)
        {
           no_data_tv.setVisibility(View.VISIBLE);
        }
        else
        {
            recyclerView.setLayoutManager(new LinearLayoutManager(FavouriteList_Activity.this));
            FavouriteListAdapter favouriteListAdapter = new FavouriteListAdapter(dbManager.fav_list(), FavouriteList_Activity.this ,this);
            recyclerView.setAdapter(favouriteListAdapter);
        }


    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void favourite(int id, int val) {
        DBManager dbManager=new DBManager(FavouriteList_Activity.this);
        dbManager.fav_update(id,val);

        Parcelable state=recyclerView.getLayoutManager().onSaveInstanceState();
        FavouriteListAdapter favouriteListAdapter = new FavouriteListAdapter(dbManager.fav_list(), FavouriteList_Activity.this, this);
        recyclerView.setAdapter(favouriteListAdapter);
        recyclerView.getLayoutManager().onRestoreInstanceState(state);

        if(dbManager.fav_list().isEmpty())
        {
            no_data_tv.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,FruitMainActivity.class);
        startActivity(intent);
    }
}