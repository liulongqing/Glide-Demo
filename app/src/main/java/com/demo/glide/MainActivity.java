package com.demo.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.demo.glide.Picasso.PicassoTransformation;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private String imgUrl = "http://pics.sc.chinaz.com/files/pic/pic9/201809/zzpic14004.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.act_main_iv);
        //Glide图片加载
//        Glide.with(this).load(imgUrl).into(imageView);
//        GlideApp.with(this)
//                .load(imgUrl)
//                .placeholder(R.drawable.ic_launcher_background)//图片加载出来前，显示的图片
//                .error(R.drawable.ic_launcher_background)//图片加载失败后，显示的图片
//                .transition(DrawableTransitionOptions.withCrossFade())//交叉淡入
//                .circleCrop()
//                .into(imageView);
        //picasso图片加载
        Picasso.with(this)
                .load(imgUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .resize(400,300)
                .onlyScaleDown()//调用resize之后，只有当原始图片的尺寸大于resize设置的尺寸，resize才起作用
                .fit()//fit 只对ImageView 有效,测量view的宽高填满view
                .centerCrop()//居中裁剪
                .rotate(60)//以0，0为原点旋转角度
                //你要做图片高斯模糊、添加圆角、做度灰处理、圆形图片等等都可以通过Transformation来完成
                .transform(new PicassoTransformation(this))
                //设置tag标签,场景1 滑动列表进行图片加载时候做滑动监听处理，滑动不加载图片，停止滑动时在加载图片
                //           场景2 图片流那种图片比较多的界面，当网络不好的时候 要退出是还没加载完，调用cancelTag停止加载
                .tag("PhotoTag")
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE) //静止内存缓存
                .networkPolicy(NetworkPolicy.NO_CACHE)//跳过磁盘缓存

                .into(imageView);
    }
}
