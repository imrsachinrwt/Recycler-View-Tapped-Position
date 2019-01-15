package com.solochoice.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.myViewHolder> {

    private Context context;
    private List<Integer> list;
    private static final String TAG = "adapter";

    public adapter(Context context, List<Integer> list) {
        this.context = context;
        this.list=list;

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: start");
        Log.d(TAG, "onCreateViewHolder:  "+viewGroup.toString());
        View view=LayoutInflater.from(context).inflate(R.layout.browsedata,viewGroup,false);
        Log.d(TAG, "onCreateViewHolder: end");
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: start");
        myViewHolder.textView.setText(list.get(i).toString());
        Log.d(TAG, "onBindViewHolder: end");
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: size of list is "+list.size());
        return list.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "myViewHolder: start");
            this.textView=(TextView) itemView.findViewById(R.id.num);
            Log.d(TAG, "myViewHolder: ends");
        }



    }


}
