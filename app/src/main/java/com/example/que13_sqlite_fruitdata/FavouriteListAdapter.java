package com.example.que13_sqlite_fruitdata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class FavouriteListAdapter extends RecyclerView.Adapter<FavouriteListAdapter.holder> {
    ArrayList<FruitData>arrayList;
    Context context;
    int fav_click,fav_id;
    private DeleteDataInterface deleteDataInterface;

    public FavouriteListAdapter(ArrayList<FruitData> arrayList, Context context,DeleteDataInterface deleteDataInterface) {
        this.arrayList = arrayList;
        this.context = context;
        this.deleteDataInterface=deleteDataInterface;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        FruitData temp = arrayList.get(position);

        holder.r_name.setText(temp.getName());
        holder.r_desc.setText(temp.getShort_desc());

        switch (temp.getId())
        {
            case 0:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/415/415682.png").into(holder.r_img);
                break;
            case 1:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/2909/2909761.png").into(holder.r_img);
                break;
            case 2:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/7396/7396589.png").into(holder.r_img);
                break;
            case 3:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/135/135620.png").into(holder.r_img);
                break;
            case 4:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/590/590685.png").into(holder.r_img);
                break;
            case 5:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/2909/2909899.png").into(holder.r_img);
                break;
            case 6:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/928/928143.png").into(holder.r_img);
                break;
            case 7:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/512/2482/2482074.png").into(holder.r_img);
                break;
            case 8:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/128/135/135687.png").into(holder.r_img);
                break;
            case 9:
                Glide.with(context).load("https://cdn-icons-png.flaticon.com/512/540/540242.png").into(holder.r_img);
                break;

        }

        holder.r_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent = new Intent(context, FruitDetails.class);
                        intent.putExtra("ID", temp.getId());
                        intent.putExtra("Name", temp.getName());
                        //intent.putExtra("Image", onBindViewHolder(switch(position)));
                        intent.putExtra("Email", temp.getEmail());
                        intent.putExtra("Desc", temp.getDesc());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                });


         fav_click=temp.getFavourite();
        switch (fav_click)
        {
            case 0:
                holder.r_favourite_img.setImageResource(R.drawable.ic_fav_black);
                break;
            case 1:
                holder.r_favourite_img.setImageResource(R.drawable.favourite_red);
                break;
        }

        holder.r_favourite_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav_click=temp.getFavourite();
                fav_id=temp.getId();
                if(fav_click==0)
                {
                    fav_click=1;
                    holder.r_favourite_img.setImageResource(R.drawable.ic_fav_black);
                    deleteDataInterface.favourite(fav_id,fav_click);
                    Toast.makeText(context, "Removed From Favourites", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    fav_click=0;
                    holder.r_favourite_img.setImageResource(R.drawable.favourite_red);
                    deleteDataInterface.favourite(fav_id,fav_click);
                    Toast.makeText(context, "Added to Favourites", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView r_name,r_desc;
        ImageView r_img,r_favourite_img;
        public holder(@NonNull View itemView) {
            super(itemView);
            r_name = itemView.findViewById(R.id.rec_fruit_name);
            r_img = itemView.findViewById(R.id.rec_fruit_img);
            r_desc = itemView.findViewById(R.id.rec_fruit_desc);
            r_favourite_img = itemView.findViewById(R.id.rec_fruit_favourite);

        }
    }


}
