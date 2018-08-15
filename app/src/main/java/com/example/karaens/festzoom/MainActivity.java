package com.example.karaens.festzoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    boolean state;
    RelativeLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        state = false;
        mLayout = findViewById(R.id.layout);
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!state) {
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                    v.startAnimation(anim);
                    state = true;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (state) {
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            anim.setInterpolator(new ReverseInterpolator());
            mLayout.startAnimation(anim);
            state = false;
        } else
            super.onBackPressed();
    }
    }

