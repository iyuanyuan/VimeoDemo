package com.example.yuan.vimeodemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBegin;
    private RollPagerView mRollPagerView;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        init();
    }

    private void initView() {
        mBegin = (Button) findViewById(R.id.begin);

        mBegin.setOnClickListener(this);
        mRollPagerView = (RollPagerView) findViewById(R.id.rollPagerView);
    }

    private void init() {
        preferences = getSharedPreferences("count", 0);
        // 存在则打开它，否则创建新的Preferences
        int count = preferences.getInt("count", 0);// 取出数据
        if (count == 0) {

            setRollPagerView();

            // 判断程序与第几次运行，如果是第一次运行则跳转到引导页面
            SharedPreferences.Editor editor = preferences.edit();
            // 让preferences处于编辑状态
            editor.putInt("count", 1);// 存入数据
            editor.commit();// 提交修改
        } else {
            startActivity(new Intent(getApplicationContext(), IntroActivity.class));
        }


    }

    private void setRollPagerView() {

        mBegin.setVisibility(View.INVISIBLE);
        //设置播放时间间隔
        mRollPagerView.setPlayDelay(3000);
        //设置透明度
        mRollPagerView.setAnimationDurtion(100);
        //设置适配器
        mRollPagerView.setAdapter(new RollAdapter());

        ViewPager viewPager = mRollPagerView.getViewPager();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    mBegin.setVisibility(View.VISIBLE);
                    mRollPagerView.pause();
                    mRollPagerView.setHintView(null);
                } else {
                    mBegin.setVisibility(View.INVISIBLE);
                    mRollPagerView.resume();
                    mRollPagerView.setHintView(new ColorPointHintView(GuideActivity.this, Color.BLACK, Color.RED));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.begin:
                startActivity(new Intent(this, IntroActivity.class));
                break;
        }
    }
}
