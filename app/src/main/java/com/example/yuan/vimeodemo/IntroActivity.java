package com.example.yuan.vimeodemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.yuan.vimeodemo.fragment.ImgFragment;
import com.example.yuan.vimeodemo.fragment.MoreFragment;
import com.example.yuan.vimeodemo.fragment.SayFragment;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolBar;
    private Button mSay;
    private Button mImg;
    private Button mMore;
    private FrameLayout mFragment;
    private SayFragment sayFragment;
    private ImgFragment imgFragment;
    private MoreFragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        initView();
        initToolBar();
    }

    private void initToolBar() {

        mToolBar.setTitle("高晓松简介");
        setSupportActionBar(mToolBar);
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mSay = (Button) findViewById(R.id.say);
        mImg = (Button) findViewById(R.id.img);
        mMore = (Button) findViewById(R.id.more);
        mFragment = (FrameLayout) findViewById(R.id.fragment);

        mSay.setOnClickListener(this);
        mImg.setOnClickListener(this);
        mMore.setOnClickListener(this);

        sayFragment = new SayFragment();
        imgFragment = new ImgFragment();
        moreFragment = new MoreFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, sayFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.say:
                transaction.replace(R.id.fragment, sayFragment);
                break;
            case R.id.img:
                transaction.replace(R.id.fragment, imgFragment);
                break;
            case R.id.more:
                transaction.replace(R.id.fragment, moreFragment);
                break;
        }
        transaction.commit();
    }
}
