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
import android.widget.TextView;
import android.widget.Toast;



public class ResultActivity extends AppCompatActivity {
    private
    TextView jieguo;
    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        jieguo=findViewById(R.id.jieguo);
        jieguo.setText(result);
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent a=new Intent(ResultActivity.this,MainActivity.class);

                startActivity(a);

            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent b=new Intent(ResultActivity.this,Soft1709081602231Activity.class);

                startActivity(b);

            }
        });
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent c=new Intent(ResultActivity.this,PictureActivity.class);

                startActivity(c);

            }
        });

        // 通过Configuration对象 确认当前显示方向
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            Toast toast = Toast.makeText(ResultActivity.this,"为了更好的体验，请使用竖屏浏览",Toast.LENGTH_SHORT);
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
