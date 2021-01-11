package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //インテントオブジェクトを取得。
        Intent intent = getIntent();
        //リスト画面から渡されたデータを取得。
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");

        //定食名と金額を表示させるTextViewを取得。
        TextView tvMenuName = findViewById(R.id.tvMenuName);
        TextView tvMenuPrice = findViewById(R.id.tvMenuPrice);

        //TextViewに定食名と金額を表示。
        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);
    }

    /**
     * 戻るボタンをタップした時の処理。
     * @param view 画面部品。
     */
    public void onBackButtonClick(View view) {
        finish();
    }
}