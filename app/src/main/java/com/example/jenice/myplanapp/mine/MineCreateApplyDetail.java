package com.example.jenice.myplanapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVUser;
import com.example.jenice.myplanapp.R;

public class MineCreateApplyDetail extends AppCompatActivity implements View.OnClickListener{

    private TextView tvDay;
    private EditText etName,etContent;
    private ImageView ivPhoto,ivBack;
    private Button btnOK;
    private AVUser user = AVUser.getCurrentUser();
    private String name,content,day;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_create_apply_detail);

        tvDay = (TextView) findViewById(R.id.tv_mine_create_apply_detail_showday);
        etName = (EditText) findViewById(R.id.et_mine_create_apply_detail_name);
        etContent = (EditText) findViewById(R.id.et_mine_create_apply_detail_content);
        ivPhoto = (ImageView) findViewById(R.id.iv_mine_create_apply_detail_photo);
        ivBack = (ImageView) findViewById(R.id.iv_mine_create_apply_detail_back);
        btnOK = (Button) findViewById(R.id.btn_mine_create_apply_detail_ok);

        ivBack.setOnClickListener(this);
        ivPhoto.setOnClickListener(this);
        btnOK.setOnClickListener(this);
        intent = this.getIntent();
        day = intent.getStringExtra("day");
        tvDay.setText("Day "+day);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_mine_create_apply_detail_photo:
                //点击上传图片
                break;
            case R.id.iv_mine_create_apply_detail_back:
                finish();
                startActivity(new Intent(MineCreateApplyDetail.this,MineCreateApply.class));
                break;
            case R.id.btn_mine_create_apply_detail_ok:
                //没有判断是否上传图片！！！！！！
                name = etName.getText().toString();
                content = etContent.getText().toString();
                if (name.length()==0){
                    Toast.makeText(getApplicationContext(),"请填写任务名称！",Toast.LENGTH_SHORT).show();
                }else if (content.length()==0){
                    Toast.makeText(getApplicationContext(), "请填写任务步骤！", Toast.LENGTH_SHORT).show();
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name);
                    bundle.putString("day",day);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
                break;
        }
    }
}
