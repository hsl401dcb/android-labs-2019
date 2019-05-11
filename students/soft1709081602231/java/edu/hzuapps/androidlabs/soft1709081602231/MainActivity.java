package edu.hzuapps.androidlabs.soft1709081602231;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private
    RadioButton shitou, jiandao, bu;
    Button choose;
    int user, diannao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        final String[] p = new String[3];
        final Random random = new Random();
        shitou = findViewById(R.id.shitou);
        jiandao = findViewById(R.id.jiandao);
        bu = findViewById(R.id.bu);
        choose = findViewById(R.id.choose);


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diannao = Math.abs(random.nextInt() % 3);
                user = 1;
                String userchoose = null;
                if (shitou.isChecked()) {
                    p[0] = "剪刀";
                    p[1] = "石头";
                    p[2] = "布";
                    userchoose = "石头";
                } else if (jiandao.isChecked()) {
                    p[0] = "布";
                    p[1] = "剪刀";
                    p[2] = "石头";
                    userchoose = "剪刀";
                } else if (bu.isChecked()) {
                    p[0] = "石头";
                    p[1] = "布";
                    p[2] = "剪刀";
                    userchoose = "布";
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                if (diannao > user) {
                    intent.putExtra("result", "玩家:" + userchoose + "	vs	" + "熊本熊：" + p[diannao] + "\no(╥﹏╥)o你输了！");
                } else if (diannao == user) {
                    intent.putExtra("result", "玩家:" + userchoose + "	vs	" + "熊本熊：" + p[diannao] + "\n(⊙o⊙)…平局");
                } else if (diannao < user) {
                    intent.putExtra("result", "玩家:" + userchoose + "	vs	" + "熊本熊：" + p[diannao] + "\n(*^▽^*)你赢了！");
                }
                startActivity(intent);
            }
        });

        // 通过Configuration对象 确认当前显示方向
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            Toast toast = Toast.makeText(MainActivity.this,"为了更好的体验，请使用竖屏浏览",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            LinearLayout layout = (LinearLayout) toast.getView();
            layout.setBackgroundColor(Color.parseColor("#FFFFFF"));  //设置toast的背景颜色
            TextView textView = (TextView) toast.getView().findViewById(android.R.id.message); //toast显示的文本内容
            textView.setTextColor(Color.RED);   //设置toast的字体颜色
            textView.setTextSize(20);           //设置toast的字体大小
            toast.show();
        }

    }
}

