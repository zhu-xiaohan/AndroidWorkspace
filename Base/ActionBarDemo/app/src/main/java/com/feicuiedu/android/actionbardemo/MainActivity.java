package com.feicuiedu.android.actionbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by chenyan on 2016/12/22.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_pull_down)
    private Button btnPullDown;

    @BindView(R.id.btn_window)
    private Button btnWindow;

    @BindView(R.id.btn_tab)
    private Button btnTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // btnPullDown = findViewById(R.id.btn_pull_down);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_pull_down,R.id.btn_tab,R.id.btn_window})
    public void btnOnClick(Button btn) {
        Intent intent = new Intent();

        switch (btn.getId()){
            case R.id.btn_pull_down:
                intent.setClass(this,PullDownMenuActivity.class);
                break;
            case R.id.btn_tab :
                break;
            case R.id.btn_window:
                break;
        }

        startActivity(intent);
    }
}
