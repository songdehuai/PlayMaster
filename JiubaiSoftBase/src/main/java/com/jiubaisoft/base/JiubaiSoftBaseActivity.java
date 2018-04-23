package com.jiubaisoft.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiubaisoft.base.entity.User;
import com.jiubaisoft.base.utils.SPUtils;

public class JiubaiSoftBaseActivity extends AppCompatActivity {

    /**********************************View*************************************/
    private TextView title;
    private ImageView leftIv;
    private ImageView rightIv;
    private TextView rightTv;
    private FrameLayout contentFl;
    private FrameLayout emptyFl;
    private RelativeLayout titleRl;
    private View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);
    }


    public void setView(int viewId) {
        if (viewId != 0) {
            init();
            initTitle();
            contentView = View.inflate(this, viewId, null);
            contentFl.addView(contentView);
        }
    }

    public void setView(int viewId, String text) {
        if (viewId != 0) {
            init();
            initTitle();
            contentView = View.inflate(this, viewId, null);
            contentFl.addView(contentView);
        }
        if (text != null) {
            setTitle(text);
            leftIv.setVisibility(View.VISIBLE);
        }
    }

    public void setTitle(String text) {
        if (title != null) {
            title.setText(text);
        }
    }

    void init() {
        contentFl = findViewById(R.id.content_fl);
        emptyFl = findViewById(R.id.content_fl);
        titleRl = findViewById(R.id.title_rl);
    }

    void initTitle() {
        title = findViewById(R.id.title_tv);
        leftIv = findViewById(R.id.title_left_iv);
        rightIv = findViewById(R.id.title_right_iv);
        rightTv = findViewById(R.id.title_right_tv);

        leftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLeftClick();
            }
        });

        rightIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRightImageClick();
            }
        });
        rightTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRightClick();
            }
        });
    }

    public void onLeftClick() {

    }

    public void onRightClick() {
        if (rightTv != null) {
            rightTv.setVisibility(View.VISIBLE);
        }
    }

    public void onRightImageClick() {
        if (rightIv != null) {
            rightIv.setVisibility(View.VISIBLE);
        }
    }

    /**********************************User*************************************/

    private User user;

    public User getUser() {
        if (user != null) {
            user = (User) SPUtils.get(getApplicationContext(), "USER_INFO", null);
        }
        return user;
    }
}
