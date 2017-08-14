package com.example.yuan.vimeodemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private ImageView mImgWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        initAnim();
    }

    private void initView() {
        mImgWelcome = (ImageView) findViewById(R.id.imgWelcome);
    }

    private void initAnim() {
        ObjectAnimator oa = ObjectAnimator.ofFloat(mImgWelcome, "alpha", 0.2f,0.5f,1f);
        oa.setDuration(2000);
        oa.start();
        oa.addListener(this);
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

        startActivity(new Intent(this, GuideActivity.class));
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
