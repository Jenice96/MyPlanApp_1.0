package com.example.jenice.myplanapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.avos.avoscloud.AVUser;
import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.fragment.MainActivity;

import static com.example.jenice.myplanapp.R.id.btn_mine_create_apply_changeto21;

public class MineCreateApply extends AppCompatActivity implements View.OnClickListener{

    private Button btnOk,btnchangeto21;
    private ImageView ivBack,ivPhoto;
    private EditText etTitle,etIntro;
    private LinearLayout lldays;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,
            btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,btn21;
    private AVUser user = AVUser.getCurrentUser();
    private String title,intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_create_apply);

        btnOk = (Button) findViewById(R.id.btn_mine_create_apply_ok);
        btnchangeto21 = (Button) findViewById(btn_mine_create_apply_changeto21);
        ivBack = (ImageView) findViewById(R.id.iv_mine_create_apply_back);
        ivPhoto = (ImageView) findViewById(R.id.iv_mine_create_photo);
        etTitle = (EditText) findViewById(R.id.et_mine_create_apply_name);
        etIntro = (EditText) findViewById(R.id.et_mine_create_apply_dec);
        lldays = (LinearLayout) findViewById(R.id.ll_mine_create_apply_duration_2);
        btn1 = (Button) findViewById(R.id.btn_mine_create_apply_day_1);
        btn2 = (Button) findViewById(R.id.btn_mine_create_apply_day_2);
        btn3 = (Button) findViewById(R.id.btn_mine_create_apply_day_3);
        btn4 = (Button) findViewById(R.id.btn_mine_create_apply_day_4);
        btn5 = (Button) findViewById(R.id.btn_mine_create_apply_day_5);
        btn6 = (Button) findViewById(R.id.btn_mine_create_apply_day_6);
        btn7 = (Button) findViewById(R.id.btn_mine_create_apply_day_7);
        btn8 = (Button) findViewById(R.id.btn_mine_create_apply_day_8);
        btn9 = (Button) findViewById(R.id.btn_mine_create_apply_day_9);
        btn10 = (Button) findViewById(R.id.btn_mine_create_apply_day_10);
        btn11 = (Button) findViewById(R.id.btn_mine_create_apply_day_11);
        btn12 = (Button) findViewById(R.id.btn_mine_create_apply_day_12);
        btn13 = (Button) findViewById(R.id.btn_mine_create_apply_day_13);
        btn14 = (Button) findViewById(R.id.btn_mine_create_apply_day_14);
        btn15 = (Button) findViewById(R.id.btn_mine_create_apply_day_15);
        btn16 = (Button) findViewById(R.id.btn_mine_create_apply_day_16);
        btn17 = (Button) findViewById(R.id.btn_mine_create_apply_day_17);
        btn18 = (Button) findViewById(R.id.btn_mine_create_apply_day_18);
        btn19 = (Button) findViewById(R.id.btn_mine_create_apply_day_19);
        btn20 = (Button) findViewById(R.id.btn_mine_create_apply_day_20);
        btn21 = (Button) findViewById(R.id.btn_mine_create_apply_day_21);

        btnOk.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        ivPhoto.setOnClickListener(this);
        btnchangeto21.setOnClickListener(this);
        btn1.setOnClickListener(this);btn2.setOnClickListener(this);btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);btn5.setOnClickListener(this);btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);btn8.setOnClickListener(this);btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);btn11.setOnClickListener(this);btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);btn14.setOnClickListener(this);btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);btn17.setOnClickListener(this);btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);btn20.setOnClickListener(this);btn21.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            //确认创建按钮，需要判断内容都填写完整没有
            case R.id.btn_mine_create_apply_ok:
                title = etTitle.getText().toString();
                intro = etIntro.getText().toString();
                //没有判断是否上传了照片！！！！！！！！！！！！！
                if (title.length()==0){
                    Toast.makeText(getApplicationContext(), "请填写计划标题！", Toast.LENGTH_SHORT).show();
                }else if (intro.length()==0){
                    Toast.makeText(getApplicationContext(), "请填写计划简介！", Toast.LENGTH_SHORT).show();
                }else{
                    //将计划保存在Plan中，并将图片传上去
                }
                break;
            //返回上个界面
            case R.id.iv_mine_create_apply_back:
                Intent intent_back = new Intent(MineCreateApply.this, MainActivity.class);
                intent_back.putExtra("main",3);
                finish();
                startActivity(intent_back);
                break;
            //计划背景图,点击后会打开相册
            case R.id.iv_mine_create_photo:

                break;
            //选择21天
            case R.id.btn_mine_create_apply_changeto21:
                if (btnchangeto21.getText().equals("创建21天计划")){
                    lldays.setVisibility(View.VISIBLE);
                    btnchangeto21.setText("创建7天计划");
                }else if (btnchangeto21.getText().equals("创建7天计划")){
                    lldays.setVisibility(View.GONE);
                    btnchangeto21.setText("创建21天计划");
                }
                break;
            case R.id.btn_mine_create_apply_day_1:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","1"),101);
                break;
            case R.id.btn_mine_create_apply_day_2:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","2"),101);
                break;
            case R.id.btn_mine_create_apply_day_3:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","3"),101);
                break;
            case R.id.btn_mine_create_apply_day_4:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","4"),101);
                break;
            case R.id.btn_mine_create_apply_day_5:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","5"),101);
                break;
            case R.id.btn_mine_create_apply_day_6:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","6"),101);
                break;
            case R.id.btn_mine_create_apply_day_7:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","7"),101);
                break;
            case R.id.btn_mine_create_apply_day_8:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","8"),101);
                break;
            case R.id.btn_mine_create_apply_day_9:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","9"),101);
                break;
            case R.id.btn_mine_create_apply_day_10:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","10"),101);
                break;
            case R.id.btn_mine_create_apply_day_11:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","11"),101);
                break;
            case R.id.btn_mine_create_apply_day_12:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","12"),101);
                break;
            case R.id.btn_mine_create_apply_day_13:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","13"),101);
                break;
            case R.id.btn_mine_create_apply_day_14:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","14"),101);
                break;
            case R.id.btn_mine_create_apply_day_15:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","15"),101);
                break;
            case R.id.btn_mine_create_apply_day_16:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","16"),101);
                break;
            case R.id.btn_mine_create_apply_day_17:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","17"),101);
                break;
            case R.id.btn_mine_create_apply_day_18:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","18"),101);
                break;
            case R.id.btn_mine_create_apply_day_19:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","19"),101);
                break;
            case R.id.btn_mine_create_apply_day_20:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","20"),101);
                break;
            case R.id.btn_mine_create_apply_day_21:
                startActivityForResult(new Intent(MineCreateApply.this,MineCreateApplyDetail.class).putExtra("day","21"),101);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            String day = bundle.getString("day");
            if (day.equals("1")){
                btn1.setText(bundle.getString("name"));
            }else if (day.equals("2")){
                btn2.setText(bundle.getString("name"));
            }else if (day.equals("3")){
                btn3.setText(bundle.getString("name"));
            }else if (day.equals("4")){
                btn4.setText(bundle.getString("name"));
            }else if (day.equals("5")){
                btn5.setText(bundle.getString("name"));
            }else if (day.equals("6")){
                btn6.setText(bundle.getString("name"));
            }else if (day.equals("7")){
                btn7.setText(bundle.getString("name"));
            }else if (day.equals("8")){
                btn8.setText(bundle.getString("name"));
            }else if (day.equals("9")){
                btn9.setText(bundle.getString("name"));
            }else if (day.equals("10")){
                btn10.setText(bundle.getString("name"));
            }else if (day.equals("11")){
                btn11.setText(bundle.getString("name"));
            }else if (day.equals("12")){
                btn12.setText(bundle.getString("name"));
            }else if (day.equals("13")){
                btn13.setText(bundle.getString("name"));
            }else if (day.equals("14")){
                btn14.setText(bundle.getString("name"));
            }else if (day.equals("15")){
                btn15.setText(bundle.getString("name"));
            }else if (day.equals("16")){
                btn16.setText(bundle.getString("name"));
            }else if (day.equals("17")){
                btn17.setText(bundle.getString("name"));
            }else if (day.equals("18")){
                btn18.setText(bundle.getString("name"));
            }else if (day.equals("19")){
                btn19.setText(bundle.getString("name"));
            }else if (day.equals("20")){
                btn20.setText(bundle.getString("name"));
            }else if (day.equals("21")){
                btn21.setText(bundle.getString("name"));
            }
        }
    }
}
