package com.example.que13_sqlite_fruitdata;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FruitDetails2 extends AppCompatActivity {

    ImageView image_img;
    TextView name_tv,desc_tv;
    Button save_btn;
    ArrayList<com.example.que13_sqlite_fruitdata.FruitData> arrayList ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_details2);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        image_img = findViewById(R.id.fruit_details_Edit_image);
        name_tv = findViewById(R.id.fruit_details_Edit_name);
        desc_tv = findViewById(R.id.fruit_details_Edit_description);
        save_btn = findViewById(R.id.fruit_details_Edit_save_btn);


        Bundle bundle = getIntent().getExtras();
        int a = bundle.getInt("Image");
        String b = bundle.getString("Name", "");
        String c = bundle.getString("Desc", "");
        int d=bundle.getInt("ID");




//        getdata();
//        arrayList=getdata();

        image_img.setImageResource(a);
        name_tv.setText(b);
        desc_tv.setText(c);

        //int e=arrayList.indexOf(d);
        //Toast.makeText(this, d, Toast.LENGTH_SHORT).show();
        switch (d)
        {
            case 0:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/415/415682.png").into(image_img);
                break;
            case 1:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/2909/2909761.png").into(image_img);
                break;
            case 2:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/7396/7396589.png").into(image_img);
                break;
            case 3:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/135/135620.png").into(image_img);
                break;
            case 4:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/590/590685.png").into(image_img);
                break;
            case 5:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/2909/2909899.png").into(image_img);
                break;
            case 6:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/928/928143.png").into(image_img);
                break;
            case 7:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/512/2482/2482074.png").into(image_img);
                break;
            case 8:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/135/135687.png").into(image_img);
                break;
            case 9:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/512/540/540242.png").into(image_img);
                break;


        }


        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x=name_tv.getText().toString();
                String y=desc_tv.getText().toString();
               // arrayList.set(d,new FruitData(0,a,x,"SHORT",y,"EMAIL"));
                DBManager dbManager=new DBManager(FruitDetails2.this);
                dbManager.update(d,x,y);

                //savedata(arrayList,"");

                Toast.makeText(FruitDetails2.this, "Data Added", Toast.LENGTH_SHORT).show();



            }
        });
    }

//    private void savedata(ArrayList<FruitData> list, String key) {
//        SharedPreferences sharedPreferences=getSharedPreferences("Save", MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        Gson gson=new Gson();
//        String json=gson.toJson(list);
//        editor.putString("Task",json);
//        editor.apply();
//    }
//
//    public ArrayList<FruitData> getdata()
//    {
//        SharedPreferences sharedPreferences = getSharedPreferences("Save", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("Task","");
//        Type type = new TypeToken<ArrayList<FruitData>>() {}.getType();
//        arrayList=gson.fromJson(json, type);
//        return arrayList;
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(FruitDetails2.this, FruitMainActivity.class);
        startActivity(intent);
        super.onRestart();
    }


}


