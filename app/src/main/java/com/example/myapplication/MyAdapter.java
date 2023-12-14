package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText;

        TextView myText2;

        TextView myText3;

        TextView myText4;

        MyViewHolder(View view) {
            super(view);
            myPicture = view.findViewById(R.id.imageView);
            myText = view.findViewById(R.id.textView);
            myText2 = view.findViewById(R.id.textView2);

            myText3 = view.findViewById(R.id.textView3);

            myText4 = view.findViewById(R.id.textView4);

        }

    }

    private ArrayList<department> departmentList;

    MyAdapter(ArrayList<department> department) {
        this.departmentList = department;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.myPicture.setImageResource(departmentList.get(position).getImage_id());
        myViewHolder.myText.setText(departmentList.get(position).getDepartment_name());
        myViewHolder.myText2.setText(departmentList.get(position).getDepartment_url());
        myViewHolder.myText3.setText(departmentList.get(position).getDepartment_number());
        myViewHolder.myText4.setText(departmentList.get(position).getDepartment_email());

        myViewHolder.myText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(departmentList.get(holder.getAdapterPosition()).getDepartment_url()));
                context.startActivity(intent);
            }
        });

        myViewHolder.myText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_DIAL,
               Uri.parse("tel:"+departmentList.get(holder.getAdapterPosition()).getDepartment_number()));
                context.startActivity(intent);
            }
        });
        myViewHolder.myText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                String[] address = {"email@address.com"};


                context.startActivity(intent);
            }
        });

        myViewHolder.myPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MainActivity2.class);
                context.startActivity(intent);
            }
        });


    }







    @Override
    public int getItemCount() {
        return departmentList.size();
    }

}
