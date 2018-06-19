package com.example.administrator.viewpagertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);
        Button button3=(Button) findViewById(R.id.button3);
    }

    public void onClick(View v){
      switch (v.getId()){
          case R.id.button1:
              Intent intent1=new Intent(MainActivity.this,MainFragmentActivity.class);
              startActivity(intent1);
              break;
          case R.id.button2:
              Intent intent2=new Intent(MainActivity.this,ViewPagerTest.class);
              startActivity(intent2);
              break;
          case R.id.button3:
              Intent intent3=new Intent(MainActivity.this,FragmentViewPagerTest.class);
              startActivity(intent3);
              break;
          default:
              break;
      }

    }

}
