package com.solochoice.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnItemClickListener extends RecyclerView.SimpleOnItemTouchListener {


    private GestureDetectorCompat gestureDetector;
    private OnClickListener onClickListener;

    interface OnClickListener{
        void onTap(View view,int position);
    }


    public OnItemClickListener(Context context, final RecyclerView recyclerView, final OnClickListener onClickListener) {
        this.onClickListener=onClickListener;
        gestureDetector=new GestureDetectorCompat(context,new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {

                View view=recyclerView.findChildViewUnder(e.getX(),e.getY());
               if(onClickListener!=null && view!=null){
                   onClickListener.onTap(view,recyclerView.getChildAdapterPosition(view));

               }

                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        if(onClickListener!=null){
            return gestureDetector.onTouchEvent(e);
        }


        return false;
    }
}
