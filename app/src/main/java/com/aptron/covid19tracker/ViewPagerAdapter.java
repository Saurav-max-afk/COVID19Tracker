package com.aptron.covid19tracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.causes,R.drawable.structures};

    public ViewPagerAdapter(Context context){
        this.context=context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.view_pager,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.image_view);
        imageView.setImageResource(images[position]);
        
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){


                   Intent ourIntent = new Intent(context,WhatActivity.class);
                    context.startActivity(ourIntent);
                }else if (position == 1){
                    Intent ourIntent1 = new Intent(context,SymptomsActivity.class);
                    context.startActivity(ourIntent1);

                }
                else if (position == 2){
                    Intent ourIntent2 = new Intent(context,Precaution.class);
                    context.startActivity(ourIntent2);

                }else if (position == 3){
                    Intent ourIntent3 = new Intent(context,CausesActivity.class);
                    context.startActivity(ourIntent3);

                }else {
                    Intent ourIntent4 = new Intent(context,StructuresActivity.class);
                    context.startActivity(ourIntent4);

                }
            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view= (View) object;
        vp.removeView(view);
    }

}
