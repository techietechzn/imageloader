package com.dpk.imageloaders;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bPicasso;
    Button bGlide;
    Button bFresco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPicasso = (Button) findViewById(R.id.bPicasso);
        bGlide = (Button) findViewById(R.id.bGlide);
        bFresco = (Button) findViewById(R.id.bFresco);
        bPicasso.setOnClickListener(this);
        bGlide.setOnClickListener(this);
        bFresco.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,ImageLoadingActivity.class);
        int libId=0;
        switch (view.getId()){
            case R.id.bPicasso:
                libId = 0;
                break;
            case R.id.bGlide:
                libId = 1;
                break;
            case R.id.bFresco:
                libId = 2;
                break;
        }
        intent.putExtra("libId",libId);
        startActivity(intent);
    }
}
