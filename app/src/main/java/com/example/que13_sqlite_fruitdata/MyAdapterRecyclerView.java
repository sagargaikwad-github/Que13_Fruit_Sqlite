package com.example.que13_sqlite_fruitdata;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;

import static androidx.core.app.ActivityCompat.finishAffinity;
import static androidx.core.app.ActivityCompat.recreate;
import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.getDrawable;
import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.SplittableRandom;


public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.holder>  {
    ArrayList<FruitData> arrayList;
    Context context;
    BottomSheetDialog sheetDialog;
    ArrayList<FruitData> a2 = new ArrayList<>();
    DBManager dbManager = new DBManager(context);
    private ArrayList<FruitData> itemsListFilter = new ArrayList<>();
    private MainActivity mainActivity;
    private DeleteDataInterface deleteDataInterface;
    int fav_click;
    int fav_id;

    public MyAdapterRecyclerView(ArrayList<FruitData> arrayList, Context context,DeleteDataInterface deleteDataInterface) {
        this.arrayList = arrayList;
        this.itemsListFilter = arrayList;
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
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
        //final FruitData temp=arrayList.get(position);

         FruitData temp = arrayList.get(position);

//        holder.r_img.setImageResource(arrayList.get(position).getImage());
       // Glide.with(context).load(temp.getImage()).into(holder.r_img);

        holder.r_name.setText(temp.getName());
        holder.r_desc.setText(temp.getShort_desc());


        fav_click=temp.getFavourite();
        switch (fav_click)
        {
            case 0:
                holder.r_favourite.setImageResource(R.drawable.ic_fav_black);
                break;
            case 1:
                holder.r_favourite.setImageResource(R.drawable.favourite_red);
                break;
        }

        holder.r_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav_click=temp.getFavourite();
                fav_id=temp.getId();
                if(fav_click==1)
                {
                    fav_click=0;
                    holder.r_favourite.setImageResource(R.drawable.ic_fav_black);
                    deleteDataInterface.favourite(fav_id,fav_click);
                    Toast.makeText(context, "Removed From Favourites", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    fav_click=1;
                    holder.r_favourite.setImageResource(R.drawable.favourite_red);
                    deleteDataInterface.favourite(fav_id,fav_click);
                    Toast.makeText(context, "Added to Favourites", Toast.LENGTH_SHORT).show();
                }

            }
        });


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


//        FruitData obj=arrayList.get(position);
//        String text=obj.getName();
//        int img=obj.getImage();
//
//        holder.r_name.setText(text);
//        holder.r_img.setImageResource(img);



        holder.r_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(context,FruitDetails.class);
//                intent.putExtra("Name",temp.getName());
//                intent.putExtra("Image",temp.getImage());
//                intent.putExtra("Email",temp.getEmail());
//                intent.putExtra("Desc",temp.getDesc());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//                 showBottomDialog();


                sheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
                LinearLayout sheetLayout = sheetDialog.findViewById(R.id.bottom);

//            LinearLayout update=sheetDialog.findViewById(R.id.update);
//            LinearLayout delete=sheetDialog.findViewById(R.id.delete);


//                [] view=LayoutInflater.from(context).inflate(R.layout.activity_bottom_sheet_dialog,
//                        sheetLayout);

                view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet,
                        sheetLayout);

                sheetDialog.setContentView(view);
                sheetDialog.show();

                final LinearLayout update = view.findViewById(R.id.update1);
                final LinearLayout delete = view.findViewById(R.id.delete1);
                final LinearLayout viewbutton = view.findViewById(R.id.view1);


                viewbutton.setOnClickListener(new View.OnClickListener() {
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
                        sheetDialog.dismiss();

                    }
                });

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, FruitDetails2.class);
                        intent.putExtra("Position", temp.getId());
                        intent.putExtra("Name", temp.getName());
                        intent.putExtra("ID", temp.getId());
                        //intent.putExtra("Image",temp.getImage());
                        intent.putExtra("Email", temp.getEmail());
                        intent.putExtra("Desc", temp.getDesc());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        sheetDialog.dismiss();

                        ((FruitMainActivity)context).finish();  //For finishing mainactivity in background

                    }
                });


                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        arrayList.remove(holder.getAdapterPosition());
//                        Toast.makeText(context, "Fruit Deleted Sucessfully", Toast.LENGTH_LONG).show();
//                        notifyDataSetChanged();
//                        savedata(arrayList,"");
//                        sheetDialog.dismiss();

                        // here first we take an arraylist and get a sharedpreference data in that after that we remove a
                        // data from the new arraylist and that arraylist save to the sharedpreferences.

                        //a2=getdata();

//                        a2 = dbManager.getlist();
//                       for(int i=0;i<a2.size();i++)
//                       {
//                           if(a2.get(i).getId()==temp.getId())
//                           {
//                              DBManager dbManager=new DBManager(context);
//                              dbManager.delete(i);
//                           }
////
//                           //savedata(a2,"");
//                           notifyDataSetChanged();
//
//                       }

                        //Work
                       deleteDataInterface.delete(temp.getId());
                       notifyDataSetChanged();






//                         switch (i)
//                         {
//                             case 0:
//                                 dbManager.delete(0);
//                                 break;
//                             case 1:
//                                 dbManager.delete(1);
//                                 break;
//                             case 2:
//                                 dbManager.delete(2);
//                                 break;
//                             case 3:
//                                 dbManager.delete(3);
//                                 break;
//                             case 4:
//                                 dbManager.delete(4);
//                                 break;
//                             case 5:
//                                 dbManager.delete(5);
//                                 break;
//                             case 6:
//                                 dbManager.delete(6);
//                                 break;
//                         }

//                            if(a2.get(i).getId()==temp.getId())
//                            {
//                               dbManager.delete(i);
//                            }
//                            else
//                            {
//                                Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show();
//                            }



//                        Toast.makeText(context, String.valueOf(arrayList.get(position).getId()), Toast.LENGTH_SHORT).show();
//                        if(dbManager.delete(arrayList.get(position).getId())==true)
//                        {
//                            Toast.makeText(context,"Deleted", Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(context,"NOT", Toast.LENGTH_SHORT).show();
//                        }




                      //notifyDataSetChanged();
                        //a2=getdata();


                        //notifyDataSetChanged();


//                        a2.remove(a);
//                        Toast.makeText(context, String.valueOf(a), Toast.LENGTH_SHORT).show();

                        sheetDialog.dismiss();



                    }


//                    private void deleteItem() {
//                       //FruitData fn=a2.get(position);
//                        final FruitData FD=a2.get(position);
//                        for(int a=1;a<=7;a++)
//                        {
//                           a2.remove(a2.get(FD.getId()));
//                            //Toast.makeText(context, String.valueOf(a), Toast.LENGTH_SHORT).show();
//                        }
//                        savedata(a2,"");
//
//                    }

                });
            }

        });

    }




//    private void showBottomDialog() {
//            sheetDialog=new BottomSheetDialog(context,R.style.BottomSheetTheme);
//            LinearLayout sheetLayout=sheetDialog.findViewById(R.id.Lay);
//
////            LinearLayout update=sheetDialog.findViewById(R.id.update);
////            LinearLayout delete=sheetDialog.findViewById(R.id.delete);
//
//            View view=LayoutInflater.from(context).inflate(R.layout.activity_bottom_sheet_dialog,
//                    sheetLayout);
//
//            sheetDialog.setContentView(view);
//            sheetDialog.show();
//
//            final LinearLayout update=view.findViewById(R.id.update);
//            final LinearLayout delete=view.findViewById(R.id.delete);
//
//
//
//
//
//    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filterList(ArrayList<FruitData> filterllist) {
        arrayList = filterllist;
        notifyDataSetChanged();
    }



    class holder extends RecyclerView.ViewHolder {
        TextView r_name,r_desc;
        ImageView r_img,r_favourite;

        public holder(@NonNull View itemView) {
            super(itemView);
            r_name = itemView.findViewById(R.id.rec_name);
            r_img = itemView.findViewById(R.id.rec_img);
            r_desc = itemView.findViewById(R.id.rec_desc);


            r_favourite = itemView.findViewById(R.id.rec_favourite);



        }


    }

//    private void savedata(ArrayList<FruitData> list, String key) {
//        SharedPreferences sharedPreferences= context.getSharedPreferences("Save", MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//        Gson gson=new Gson();
//        String json=gson.toJson(list);
//        editor.putString("Task",json);
//        editor.apply();
//    }
//    public ArrayList<FruitData> getdata()
//    {
//        SharedPreferences sharedPreferences = context.getSharedPreferences("Save", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("Task","");
//        Type type = new TypeToken<ArrayList<FruitData>>() {}.getType();
//        arrayList=gson.fromJson(json, type);
//        return arrayList;
//    }


 
}


