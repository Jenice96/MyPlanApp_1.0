package com.example.jenice.myplanapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;
import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.fragment.MainActivity;

public class MinePocket extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivBack,ivMedal1,ivMedal2,ivMedal3,ivMedal4,ivMedal5,ivMedal6;
    private TextView tvMedalIntro,tvMoney;
    private AVUser user = AVUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_pocket);

        ivBack = (ImageView) findViewById(R.id.iv_mine_pocket_back);
        ivMedal1 = (ImageView) findViewById(R.id.iv_mine_pocket_medal_1);
        ivMedal2 = (ImageView) findViewById(R.id.iv_mine_pocket_medal_2);
        ivMedal3 = (ImageView) findViewById(R.id.iv_mine_pocket_medal_3);
        ivMedal4 = (ImageView) findViewById(R.id.iv_mine_pocket_medal_4);
        ivMedal5 = (ImageView) findViewById(R.id.iv_mine_pocket_medal_5);
        ivMedal6 = (ImageView) findViewById(R.id.iv_mine_pocket_medal_6);
        tvMedalIntro = (TextView) findViewById(R.id.tv_mine_pocket_medal_intro);
        tvMoney = (TextView) findViewById(R.id.tv_mine_pocket_money_show);

        ivBack.setOnClickListener(this);
        ivMedal1.setOnClickListener(this);
        ivMedal2.setOnClickListener(this);
        ivMedal3.setOnClickListener(this);
        ivMedal4.setOnClickListener(this);
        ivMedal5.setOnClickListener(this);
        ivMedal6.setOnClickListener(this);
        tvMedalIntro.setOnClickListener(this);

        tvMoney.setText(user.getString("coin"));
        setMedalState();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.iv_mine_pocket_back:
                Intent intent_back = new Intent(MinePocket.this, MainActivity.class);
                intent_back.putExtra("main",3);
                finish();
                startActivity(intent_back);
                break;
            //点击勋章查看勋章详情
            case R.id.iv_mine_pocket_medal_1:

                break;
            case R.id.iv_mine_pocket_medal_2:

                break;
            case R.id.iv_mine_pocket_medal_3:

                break;
            case R.id.iv_mine_pocket_medal_4:

                break;
            case R.id.iv_mine_pocket_medal_5:

                break;
            case R.id.iv_mine_pocket_medal_6:

                break;
            //点击文字查看如何获取勋章
            case R.id.tv_mine_pocket_medal_intro:

                break;
        }
    }

    //设置勋章的亮暗
    private void setMedalState(){
        if (user.getBoolean("isMedal1")==true)
            ivMedal1.setImageResource(R.drawable.medal1_light);
        if (user.getBoolean("isMedal2")==true)
            ivMedal2.setImageResource(R.drawable.medal2_light);
        if (user.getBoolean("isMedal3")==true)
            ivMedal3.setImageResource(R.drawable.medal3_light);
        if (user.getBoolean("isMedal4")==true)
            ivMedal4.setImageResource(R.drawable.medal4_light);
        if (user.getBoolean("isMedal5")==true)
            ivMedal5.setImageResource(R.drawable.medal5_light);
        if (user.getBoolean("isMedal6")== true)
            ivMedal6.setImageResource(R.drawable.medal6_light);
    }
}
