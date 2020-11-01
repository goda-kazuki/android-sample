package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ダークモードを拒否
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick=findViewById(R.id.btClick);
        HelloListener helloListener=new HelloListener();

        btClick.setOnClickListener(helloListener);

        Button btClear=findViewById(R.id.btClear);
        btClear.setOnClickListener(helloListener);
    }

    private class HelloListener implements View.OnClickListener{
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view){
            EditText input=findViewById(R.id.etName);

            TextView output=findViewById(R.id.tvOutput);

            String inputStr=input.getText().toString();

            int id=view.getId();

            switch (id){
                case R.id.btClick:
                    output.setText(inputStr + "さん、こんにちは");
                    break;

                case R.id.btClear:
                    output.setText("");
                    break;
            }
        }
    }

}