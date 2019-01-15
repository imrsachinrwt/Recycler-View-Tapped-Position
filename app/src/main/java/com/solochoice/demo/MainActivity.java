package com.solochoice.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements OnItemClickListener.OnClickListener {

    private RecyclerView recyclerView;
    private adapter myadapter;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        ArrayList<Integer> value=new ArrayList<>();
        Log.d(TAG, "onCreate: start");
        for (int i = 0; i <= 10000; i++) {
            value.add(i,i);
        }
        Log.d(TAG, "onCreate: size of value is "+value.size());
        Log.d(TAG, "onCreate: adapter start");
        myadapter=new adapter(this,value);
        Log.d(TAG, "onCreate: set layout manager start");
        recyclerView.addOnItemTouchListener(new OnItemClickListener(this,recyclerView,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
        Log.d(TAG, "onCreate: ends");

    }


    @Override
    public void onTap(View view, int position) {
        Toast.makeText(this,"tapped at position "+position,Toast.LENGTH_SHORT).show();
    }
}







