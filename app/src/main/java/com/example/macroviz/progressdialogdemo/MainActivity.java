package com.example.macroviz.progressdialogdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnWait;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnWait = findViewById(R.id.btnWait);
        btnWait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = ProgressDialog.show(MainActivity.this,
                        "讀取中", "請等待3秒...",true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(3000);
                        }catch(Exception e){
                            e.printStackTrace();
                        }finally {
                            dialog.dismiss();
                        }
                    }
                }).start();
            }
        });
    }
}
