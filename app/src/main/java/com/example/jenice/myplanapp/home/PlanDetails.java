package com.example.jenice.myplanapp.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.CloudQueryCallback;
import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.adapter.PlanItemAdapter;
import com.example.jenice.myplanapp.entity.PlanDetail;
import com.example.jenice.myplanapp.task.updatePlanImgTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jenice on 2017/4/24.
 */

public class PlanDetails  extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String plan_name;
    ImageView PlanImg;
    ImageView PersonImg;
    TextView UserGoal;
    List<PlanDetail> detail_list=new ArrayList<PlanDetail>();
    PlanItemAdapter adapter;
    ListView plan_detail_list;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_details);
        context=this;

        //接收上一个界面的传递参数
        Bundle bundle = this.getIntent().getExtras();
        plan_name=bundle.getString("PlanName");
        String plan_declaration=bundle.getString("PlanDeclaration");
        final String user_name=bundle.getString("UserName");

        //计划相关内容
        TextView PlanName= (TextView) findViewById(R.id.plan_detail_name);
        TextView PlanDeclaration= (TextView) findViewById(R.id.plan_detail_declaration);
        PlanImg= (ImageView) findViewById(R.id.plan_detail_img);
        PlanName.setText(plan_name);
        PlanDeclaration.setText(plan_declaration);
        String cql = "select url from _File where name=?";
        AVQuery.doCloudQueryInBackground(cql, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                String url =  avCloudQueryResult.getResults().get(0).getString("url");
                //开启异步线程加载图片
                new updatePlanImgTask(PlanImg).execute(url,plan_name);
            }
        }, plan_name);

        //计划创建用户的相关内容
        TextView UserNickName= (TextView) findViewById(R.id.plan_detail_personname);
        UserNickName.setText(user_name);
        UserGoal= (TextView) findViewById(R.id.plan_detail_person_decla);
        PersonImg= (ImageView) findViewById(R.id.plan_detail_photo);
        //加载用户头像
        String cql1 = "select url from _File where name=?";
        AVQuery.doCloudQueryInBackground(cql1, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                String url =  avCloudQueryResult.getResults().get(0).getString("url");
                //开启异步线程加载图片
                new updatePlanImgTask(PersonImg).execute(url,user_name);
            }
        }, user_name);
        //加载用户名称和宣言
        String cql2 = "select * from _User where username=?";
        AVQuery.doCloudQueryInBackground(cql2, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult1, AVException e) {
                String goal = avCloudQueryResult1.getResults().get(0).getString("goal");
                UserGoal.setText(goal);
            }
        },user_name);

        //加载计划列表
        plan_detail_list= (ListView) findViewById(R.id.Plan_Detail_List);
        plan_detail_list.setOnItemClickListener(this);
        String cql3 = "select * from PlanDetail where PlanName = ? order by PlanDay";
        AVQuery.doCloudQueryInBackground(cql3, new CloudQueryCallback<AVCloudQueryResult>() {
            @Override
            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                detail_list = (List<PlanDetail>)avCloudQueryResult.getResults();
                adapter = new PlanItemAdapter(context, R.layout.plan_detail_item, detail_list);
                plan_detail_list.setAdapter(adapter);
            }
        },PlanDetail.class,plan_name);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle=new Bundle();
        PlanDetail choose_plan=detail_list.get(position);
        bundle.putString("PlanDetailName",choose_plan.getPlanContent());
        bundle.putInt("PlanDay",choose_plan.getPlanDay());
        bundle.putString("PlanName",plan_name);

        Intent intent = new Intent(PlanDetails.this,DayDuty.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

