package com.example.threebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE="com.example.threebutton.extra.TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void launchSecondActivity(View view) {
        Intent intent=new Intent(this, SecondActivity.class);
        switch(view.getId()){
            case R.id.button1:
                intent.putExtra(EXTRA_MESSAGE,getString(R.string.para1));
                startActivity(intent);
                break;
            case R.id.button2:
                intent.putExtra(EXTRA_MESSAGE,getString(R.string.para2));
                startActivity(intent);
                break;
            case R.id.button3:
                intent.putExtra(EXTRA_MESSAGE,getString(R.string.para3));
                startActivity(intent);
                break;
            default:
                Toast.makeText(MainActivity.this, "There was an error", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}