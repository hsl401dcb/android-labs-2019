package edu.hzuapps.androidlabs.soft1709081602231;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PictureActivity extends AppCompatActivity {
    private Button bg1,bg2,bg3,bg4;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_activity);
        bg1 = findViewById(R.id.bg1);
        bg2 = findViewById(R.id.bg2);
        bg3 = findViewById(R.id.bg3);
        bg4 = findViewById(R.id.bg4);
        imageview =findViewById(R.id.imageView);
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

        bg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bg4.setEnabled(true);
                String strURL = "http://img16.3lian.com/gif2016/q6/39/d/109.jpg";
                try {
                    Bitmap bitmap = getBitmap(strURL);
                    imageview.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
