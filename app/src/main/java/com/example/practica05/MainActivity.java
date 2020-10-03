package com.example.practica05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<ImageView> images;
    final int listSize = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images= new ArrayList<>();
        for(int i = 1; i < listSize; i++){
            System.out.println(getResources().getIdentifier("imageView"+i, "id",  getPackageName()));
            images.add((ImageView)findViewById(getResources().getIdentifier("imageView"+i, "id",  getPackageName())));
            images.get(i-1).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        for(int i = 0; i < images.size() ; i++){
            if(v.getId() == getResources().getIdentifier("imageView"+(i+1), "id", getPackageName())){
                int randomImage = (int) Math.floor(Math.random()*9+1);
                images.get(i).setImageResource(getResources().getIdentifier("animal"+(randomImage), "mipmap",  getPackageName()));
            }
        }
    }
}