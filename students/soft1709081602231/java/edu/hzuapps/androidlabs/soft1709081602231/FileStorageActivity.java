package edu.hzuapps.androidlabs.soft1709081602231;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStorageActivity extends AppCompatActivity {
    private EditText editText;
    private Button save,read,home;
    private TextView textView2;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_storage_activity);
        editText=findViewById(R.id.editText);
        save=findViewById(R.id.save);
        read=findViewById(R.id.read);
        home=findViewById(R.id.home);
        textView2=findViewById(R.id.textView2);
        save.setOnClickListener(new ButtonListener());
        read.setOnClickListener(new ButtonListener());
        home.setOnClickListener(new ButtonListener());
    }
    private class ButtonListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.save:
                    String saveinfo=editText.getText().toString().trim();
                    FileOutputStream fos;
                    try{
                        fos=openFileOutput("data.txt", Context.MODE_PRIVATE);
                        fos.write(saveinfo.getBytes());
                        fos.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Toast.makeText(FileStorageActivity.this,"修改成功",0).show();
                    break;
                case R.id.read:
                    String content="";
                    try{
                        FileInputStream fis=openFileInput("data.txt");
                        byte[] buffer=new byte[fis.available()];
                        fis.read(buffer);
                        content=new String(buffer);
                        String content1 = content; //从edit text中获取内容
                        textView2.setText(content1); // 在textview中显示.
                        fis.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.home:
                    Intent a = new Intent(FileStorageActivity.this,Soft1709081602231Activity.class);

                    startActivity(a);
                    break;
                    default:
                    break;
            }
        }
    }
}


