package com.example.practica05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<ImageView> images;
    int id;
    Class clazz;
    Field f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images= new ArrayList<ImageView>();
        for(int i = 0; i<9; i++){
            int j= i+1;
            String aux = String.valueOf(j);
            clazz = R.id.class;
            f = null;
            try {
                f = clazz.getField("imageView" + j);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }finally {
                try {
                     id = f.getInt(null);  // pass in null, since field is a static field.
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(f);
                    images.add((ImageView) findViewById(id));

                }
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageView1:
                images.get(0).setImageResource(R.mipmap.animal9);
                System.out.println("This is 1");
                break;
            case R.id.imageView2:
                images.get(1).setImageResource(R.mipmap.animal8);
                System.out.println("This is 2");

                break;
            case R.id.imageView3:
                images.get(2).setImageResource(R.mipmap.animal7);
                System.out.println("This is 3");

                break;
            case R.id.imageView4:
                images.get(3).setImageResource(R.mipmap.animal7);
                System.out.println("This is 4");

                break;
            case R.id.imageView5:
                images.get(4).setImageResource(R.mipmap.animal5);
                System.out.println("This is 5");

                break;
            case R.id.imageView6:
                images.get(5).setImageResource(R.mipmap.animal4);
                System.out.println("This is 6");

                break;
            case R.id.imageView7:
                images.get(6).setImageResource(R.mipmap.animal3);
                System.out.println("This is 7");

                break;
            case R.id.imageView8:
                images.get(7).setImageResource(R.mipmap.animal2);
                System.out.println("This is 8");

                break;
            case R.id.imageView9:
                images.get(8).setImageResource(R.mipmap.animal1);
                System.out.println("This is 9");

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}