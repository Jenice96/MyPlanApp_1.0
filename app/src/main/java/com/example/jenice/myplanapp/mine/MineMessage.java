package com.example.jenice.myplanapp.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jenice.myplanapp.R;
import com.example.jenice.myplanapp.fragment.MainActivity;

public class MineMessage extends AppCompatActivity implements View.OnClickListener{

    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_message);

        ivBack = (ImageView) findViewById(R.id.iv_mine_message_back);
        ivBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.iv_mine_message_back:
                Intent intent_back = new Intent(MineMessage.this, MainActivity.class);
                intent_back.putExtra("main",3);
                finish();
                startActivity(intent_back);
                break;
        }
    }
}
