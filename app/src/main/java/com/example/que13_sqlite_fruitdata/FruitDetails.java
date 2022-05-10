package com.example.que13_sqlite_fruitdata;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class FruitDetails extends AppCompatActivity {
    TextView name, description, link;
    ImageView image;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_fruit_details);


        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        image = findViewById(R.id.image);
        link = findViewById(R.id.link);


        Bundle bundle = getIntent().getExtras();
        String fruit_name = bundle.getString("Name", "");
        int fruit_image = bundle.getInt("Image");
        int fruit_id=bundle.getInt("ID");
        String fruit_description = bundle.getString("Desc", "");
        String fruit_link = bundle.getString("Email", "");

        name.setText(fruit_name);
        image.setImageResource(fruit_image);
        description.setText(fruit_description);
        link.setText("Read More...");

        switch (fruit_id)
        {
            case 0:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/415/415682.png").into(image);
                break;
            case 1:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/2909/2909761.png").into(image);
                break;
            case 2:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/7396/7396589.png").into(image);
                break;
            case 3:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/135/135620.png").into(image);
                break;
            case 4:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/590/590685.png").into(image);
                break;
            case 5:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/2909/2909899.png").into(image);
                break;
            case 6:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/928/928143.png").into(image);
                break;
            case 7:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/512/2482/2482074.png").into(image);
                break;
            case 8:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/128/135/135687.png").into(image);
                break;
            case 9:
                Glide.with(this).load("https://cdn-icons-png.flaticon.com/512/540/540242.png").into(image);
                break;

        }

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(fruit_link));
                startActivity(intent);
            }
        });


    }
}