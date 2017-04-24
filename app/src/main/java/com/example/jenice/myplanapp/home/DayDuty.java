package com.example.jenice.myplanapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CloudQueryCallback;
import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.task.updatePlanImgTask;

/**
 * Created by Jenice on 2017/4/24.
 */

public class DayDuty extends AppCompatActivity {
    TextView duty_instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_duty);

        Bundle bundle = this.getIntent().getExtras();
        int plan_day=bundle.getInt("PlanDay");
        String detail_name=bundle.getString("PlanDetailName");
        String plan_name=bundle.getString("PlanName");

        TextView duty_day= (TextView) findViewById(R.id.day_duty_daynum);
        duty_day.setText("DAY"+plan_day);
        TextView duty = (TextView) findViewById(R.id.day_duty_declaration2);
        duty.setText(detail_name);
        TextView duty_plan_name= (TextView) findViewById(R.id.day_duty_plan_name);
        duty_plan_name.setText(plan_name);

        //任务的具体内容
        duty_instruction= (TextView) findViewById(R.id.day_duty_content);
        String cql = "select PlanInstruction from PlanDetail where PlanName = ? and PlanDay=?";
        AVQuery.doCloudQueryInBackground(cql, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                String content = avCloudQueryResult.getResults().get(0).getString("PlanInstruction");
                duty_instruction.setText(content);
            }
        },plan_name,plan_day);

        //某天计划的图片
        final ImageView imageview= (ImageView) findViewById(R.id.day_duty_img);
        final String tmp_image=plan_name+plan_day+".jpg";
        String cql1 = "select url from _File where name=?";
        AVQuery.doCloudQueryInBackground(cql1, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                String url =  avCloudQueryResult.getResults().get(0).getString("url");
                //开启异步线程加载图片
                new updatePlanImgTask(imageview).execute(url,tmp_image);
            }
        }, tmp_image);
    }
}

