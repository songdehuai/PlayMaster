package com.songdehuai.playmaster;

import android.os.Bundle;

import com.jiubaisoft.base.JiubaiSoftBaseActivity;


public class MainActivity extends JiubaiSoftBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_main, "主页");
    }

    void initServer() {
        
    }

    @Override
    public void onLeftClick() {
        super.onLeftClick();
        finish();
    }
}
