package com.demo.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    private String imgUrl = "http://pics.sc.chinaz.com/files/pic/pic9/201809/zzpic14004.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.act_main_iv);
        //图片加载
//        Glide.with(this).load(imgUrl).into(imageView);
        GlideApp.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.ic_launcher_background)//图片加载出来前，显示的图片
                .error(R.drawable.ic_launcher_background)//图片加载失败后，显示的图片
                .transition(DrawableTransitionOptions.withCrossFade())//交叉淡入
                .circleCrop()
                .into(imageView);
    }
}
