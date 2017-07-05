package com.example.yang.ademomaterialdesign;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yang on 2017/6/21.
 */

public class MyAdapter  extends RecyclerView.Adapter{
    String[] strings;
    Context context;

    public MyAdapter(String[] mstrings){

        strings=mstrings;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.textView);
            textView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Snackbar.make(v,textView.getText(),Snackbar.LENGTH_LONG).show();
        }
    }
}
