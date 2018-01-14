package com.dpk.imageloaders;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

public class ImageLoadingActivity extends AppCompatActivity {
    int libId;
    ImageView ivMain;
    TextView tvLibraryName;
    String imageUrl = "https://s14.postimg.org/cfd012cap/landscape-photos-32795-33547-hd-wallpapers.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_image_loading);
        libId = getIntent().getIntExtra("libId",0);
        ivMain = (ImageView) findViewById(R.id.ivMain);
        tvLibraryName = (TextView) findViewById(R.id.tvLibraryName);

        loadImage();
    }

    private void loadImage() {
        if(libId==0){
            Picasso.with(this).load(imageUrl).into(ivMain);
            tvLibraryName.setText("Picasso");
        }else if(libId==1){
            Glide.with(this).load(imageUrl).into(ivMain);
            tvLibraryName.setText("Glide");
        }else if(libId==2){
            SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.sdvImage);
            ivMain.setVisibility(View.GONE);
            draweeView.setVisibility(View.VISIBLE);
            Uri imageUri = Uri.parse(imageUrl);
            draweeView.setImageURI(imageUri);
            tvLibraryName.setText("Fresco");
        }
    }
}
