package edu.hzuapps.androidlabs.soft1709081602231;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ResultActivity extends AppCompatActivity {
    private
    TextView jieguo,bg1,bg2,bg3;
    Button button1,button2;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        jieguo=findViewById(R.id.jieguo);
        jieguo.setText(result);
        bg1 = findViewById(R.id.bg1);
        bg2 = findViewById(R.id.bg2);
        bg3 = findViewById(R.id.bg3);
        imageview =findViewById(R.id.imageView);


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
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(
                new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());

        bg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bg1.setEnabled(true);
                String strURL = "http://img16.3lian.com/gif2016/q6/39/d/105.jpg";
                try {
                    Bitmap bitmap = getBitmap(strURL);
                    imageview.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bg2.setEnabled(true);
                String strURL = "http://img16.3lian.com/gif2016/q6/39/d/101.jpg";
                try {
                    Bitmap bitmap = getBitmap(strURL);
                    imageview.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bg3.setEnabled(true);
                String strURL = "http://img16.3lian.com/gif2016/q6/39/d/103.jpg";
                try {
                    Bitmap bitmap = getBitmap(strURL);
                    imageview.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
    public Bitmap getBitmap(String path) throws IOException {
        try {
            URL url = new URL(path);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();//获得图片的数据流
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);//读取图像数据
                return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
