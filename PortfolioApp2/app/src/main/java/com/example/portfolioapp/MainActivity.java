package com.example.portfolioapp;

import android.net.Uri;
import android.os.Bundle;

import com.example.portfolioapp.models.Portfolio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;





public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_DETAILS_CODE = 1004;
    private static final String TAG = "MainActivity";
    private String githubUserName = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addDetailsButton = findViewById(R.id.btn_add_details);
        addDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,REQUEST_DETAILS_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_DETAILS_CODE && resultCode==RESULT_OK && data!=null){
            Portfolio portfolio=data.getParcelableExtra(AddActivity.ABC);
            if(portfolio!=null){
                setDetails(portfolio);
            }
        }

    }

    private void setDetails(@NonNull Portfolio portfolio){
        TextView textViewName=findViewById(R.id.tv_name);
        TextView textViewPosition=findViewById(R.id.tv_title);
        TextView textViewEduTitle=findViewById(R.id.tv_education_title);
        TextView textViewEduDegree=findViewById(R.id.tv_education_degree);
        TextView textViewEduYear=findViewById(R.id.tv_education_year);
        TextView textViewCourseTitle=findViewById(R.id.tv_course_title);
        TextView textViewCourseDegree=findViewById(R.id.tv_course_degree);
        TextView textViewCourseYear=findViewById(R.id.tv_course_year);

        textViewName.setText(portfolio.getName());
        textViewPosition.setText(portfolio.getPosition());
        textViewEduTitle.setText(portfolio.getEducation().getUniversity());
        textViewEduDegree.setText(portfolio.getEducation().getDegree());
        textViewEduYear.setText(portfolio.getEducation().getYear());
        textViewCourseTitle.setText(portfolio.getCourse().getOrganization());
        textViewCourseDegree.setText(portfolio.getCourse().getName());
        textViewCourseYear.setText(portfolio.getCourse().getYear());

        githubUserName=portfolio.getGithubUserName();






    }

    public void openGithub(View view) {
        String githubUrl="https://github.com/";
        if(githubUserName!=null){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl+githubUserName));
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"Not a valid github username", Toast.LENGTH_SHORT).show();

        }
    }
}




