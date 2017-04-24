package com.example.jenice.myplanapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;
import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.fragment.MainActivity;

public class MinePersonal extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivBack,ivAccountGo;
    private LinearLayout llPhoto;
    private EditText etGoal,etIntro;
    private TextView tvEdit,tvName,tvSex,tvGoal,tvIntro;
    private Spinner spnSex;
    private String gender,goal,intro;

    private AVUser user = AVUser.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_personal);

        ivBack = (ImageView) findViewById(R.id.iv_mine_personal_back);
        ivAccountGo = (ImageView) findViewById(R.id.iv_mine_personal_account);
        llPhoto = (LinearLayout) findViewById(R.id.ll_mine_personal_photo);
        etGoal = (EditText) findViewById(R.id.et_mine_personal_goal_edit);
        etIntro = (EditText) findViewById(R.id.et_mine_personal_intro_edit);
        tvEdit = (TextView) findViewById(R.id.tv_mine_personal_edit);
        tvName = (TextView) findViewById(R.id.tv_mine_personal_name_show);
        tvSex = (TextView) findViewById(R.id.tv_mine_personal_sex_show);
        tvGoal = (TextView) findViewById(R.id.tv_mine_personal_goal_show);
        tvIntro = (TextView) findViewById(R.id.tv_mine_personal_intro_show);
        spnSex = (Spinner) findViewById(R.id.spn_mine_personal_sex_edit);

        ivBack.setOnClickListener(this);
        ivAccountGo.setOnClickListener(this);
        llPhoto.setOnClickListener(this);
        tvEdit.setOnClickListener(this);
        spnSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = view.getResources().getStringArray(R.array.mine_personal_sex)[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = "保密";
            }
        });

        tvName.setText(user.getUsername());
        showInfo();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            //返回按钮
            case R.id.iv_mine_personal_back:
                Intent intent_back = new Intent(MinePersonal.this, MainActivity.class);
                intent_back.putExtra("main",3);
                finish();
                startActivity(intent_back);
                break;
            //跳转到绑定账号界面
            case R.id.iv_mine_personal_account:
                Intent intent_account = new Intent(MinePersonal.this,MineAccount.class);
                finish();
                startActivity(intent_account);
                break;
            //修改头像
            case R.id.ll_mine_personal_photo:

                break;
            //编辑资料,当点击编辑会变为完成，点击完成弹出对话框，确认后修改信息
            case R.id.tv_mine_personal_edit:
                if (tvEdit.getText().equals("编辑")){
                    changeToEdit();
                }else if(tvEdit.getText().equals("完成")){
                    modifyPersonalInfo();
                    changeToDone();
                }
                break;
        }
    }

    //将界面变为编辑界面状态
    private void changeToEdit()
    {
        //性别
        tvSex.setVisibility(View.INVISIBLE);
        spnSex.setVisibility(View.VISIBLE);
        //目标
        tvGoal.setVisibility(View.INVISIBLE);
        etGoal.setVisibility(View.VISIBLE);
        //介绍
        tvIntro.setVisibility(View.INVISIBLE);
        etIntro.setVisibility(View.VISIBLE);
        //将编辑改为完成
        tvEdit.setText("完成");
    }

    //将界面变为完成界面状态
    private void changeToDone()
    {
        tvSex.setText(gender);
        tvGoal.setText(goal);
        tvIntro.setText(intro);
        //性别
        tvSex.setVisibility(View.VISIBLE);
        spnSex.setVisibility(View.INVISIBLE);
        //目标
        tvGoal.setVisibility(View.VISIBLE);
        etGoal.setVisibility(View.INVISIBLE);
        //介绍
        tvIntro.setVisibility(View.VISIBLE);
        etIntro.setVisibility(View.INVISIBLE);
        //将编辑改为完成
        tvEdit.setText("编辑");
    }

    //修改个人信息
    private void modifyPersonalInfo(){
        goal = etGoal.getText().toString();
        intro = etIntro.getText().toString();
        AVObject update = AVObject.createWithoutData("_User",user.getObjectId());
        update.put("gender",gender);
        update.put("goal",goal);
        update.put("introduction",intro);
        update.saveInBackground();
        //一定要刷新，才能保证拿到最新的数据
        update.fetchInBackground(new GetCallback<AVObject>() {
            @Override
            public void done(AVObject avObject, AVException e) {
                gender = avObject.getString("gender");
                goal = avObject.getString("goal");
                intro = avObject.getString("introduction");
            }
        });
    }

    //显示用户信息
    private void showInfo(){
        tvSex.setText(user.getString("gender"));
        tvIntro.setText(user.getString("introduction"));
        tvGoal.setText(user.getString("goal"));
        //头像的设置没有完成!!!!!!!!!!!!!!!!!!!!!
    }
}


