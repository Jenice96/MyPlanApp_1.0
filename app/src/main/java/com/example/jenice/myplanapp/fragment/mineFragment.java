package com.example.jenice.myplanapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;
import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.mine.MineCreateApply;
import com.example.jenice.myplanapp.mine.MineMessage;
import com.example.jenice.myplanapp.mine.MinePersonal;
import com.example.jenice.myplanapp.mine.MinePocket;
import com.example.jenice.myplanapp.mine.MineSetting;

/**
 * A simple {@link Fragment} subclass.
 */
public class mineFragment extends Fragment {

    private View view;
    private RelativeLayout rlSetting,rlPocket,rlMessage,rlCollect,rlCreate,rlPlan,rlPersonal;
    private TextView tvUsername;
    private ImageView ivBackgroung,ivPhoto;

    private AVUser user = AVUser.getCurrentUser();

    public mineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_mine, container, false);
        rlSetting = (RelativeLayout) view.findViewById(R.id.rl_mine_function_setting);
        rlPocket = (RelativeLayout) view.findViewById(R.id.rl_mine_function_pocket);
        rlMessage = (RelativeLayout) view.findViewById(R.id.rl_mine_function_message);
        rlCollect = (RelativeLayout) view.findViewById(R.id.rl_mine_function_collect);
        rlCreate = (RelativeLayout) view.findViewById(R.id.rl_mine_function_create);
        rlPlan = (RelativeLayout) view.findViewById(R.id.rl_mine_function_plan);
        rlPersonal = (RelativeLayout) view.findViewById(R.id.rl_mine_personal);
        tvUsername = (TextView) view.findViewById(R.id.tv_mine_name);
        ivPhoto = (ImageView) view.findViewById(R.id.iv_mine_photo);
        ivBackgroung = (ImageView) view.findViewById(R.id.iv_mine_backgound);

        tvUsername.setText(user.getUsername());
        //图片背景图都没设置！！！！！！！！！！！！
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //设置部分
        rlSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_setting = new Intent(getActivity(),MineSetting.class);
                getActivity().finish();
                startActivity(intent_setting);
            }
        });
        //钱包部分
        rlPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_pocket = new Intent(getActivity(), MinePocket.class);
                getActivity().finish();
                startActivity(intent_pocket);
            }
        });
        //消息部分
        rlMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_message = new Intent(getActivity(), MineMessage.class);
                getActivity().finish();
                startActivity(intent_message);
            }
        });
        //收藏部分
        rlCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //创建计划部分
        rlCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_create = new Intent(getActivity(), MineCreateApply.class);
                getActivity().finish();
                startActivity(intent_create);
            }
        });
        //我的计划部分
        rlPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //个人资料部分
        rlPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_personal = new Intent(getActivity(), MinePersonal.class);
                getActivity().finish();
                startActivity(intent_personal);
            }
        });
    }
}
