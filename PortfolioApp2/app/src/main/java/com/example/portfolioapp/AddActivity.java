package com.example.portfolioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

import com.example.portfolioapp.models.Course;
import com.example.portfolioapp.models.Education;
import com.example.portfolioapp.models.Portfolio;

public class AddActivity extends AppCompatActivity {
    public static final String ABC="param-portfolio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void submitData(View view){
        EditText etName=findViewById(R.id.et_name);
        EditText etPosition=findViewById(R.id.et_position);
        EditText etUniversity=findViewById(R.id.et_university);
        EditText etDegree=findViewById(R.id.et_degree);
        EditText etYear=findViewById(R.id.et_education_year);
        EditText etOrganization=findViewById(R.id.et_organization_name);
        EditText etCourseName=findViewById(R.id.et_course_name);
        EditText etCourseYear=findViewById(R.id.et_course_year);
        EditText etGithub=findViewById(R.id.et_github);

        if(etName.getText().toString().isEmpty()||etName.getText().toString()==null){
            etName.setError(("Valid Name mandatory"));
            etName.requestFocus();
        }
        if(etPosition.getText().toString().isEmpty()||etPosition.getText().toString()==null){
            etPosition.setError(("Valid Position mandatory"));
            etPosition.requestFocus();
        }
        if(etUniversity.getText().toString().isEmpty()||etUniversity.getText().toString()==null){
            etUniversity.setError(("Valid University name mandatory"));
            etUniversity.requestFocus();
        }
        if(etDegree.getText().toString().isEmpty()||etDegree.getText().toString()==null){
            etDegree.setError(("Valid Degree mandatory"));
            etDegree.requestFocus();
        }
        if(etYear.getText().toString().isEmpty()||etYear.getText().toString()==null){
            etYear.setError(("Valid Year mandatory"));
            etYear.requestFocus();
        }
        if(etOrganization.getText().toString().isEmpty()||etOrganization.getText().toString()==null){
            etOrganization.setError(("Valid Organization name mandatory"));
            etOrganization.requestFocus();
        }
        if(etCourseName.getText().toString().isEmpty()||etCourseName.getText().toString()==null){
            etCourseName.setError(("Valid Course Name mandatory"));
            etCourseName.requestFocus();
        }
        if(etCourseYear.getText().toString().isEmpty()||etCourseName.getText().toString()==null){
            etCourseYear.setError(("Valid Course Year mandatory"));
            etCourseYear.requestFocus();
        }
        if(etGithub.getText().toString().isEmpty()||etGithub.getText().toString()==null){
            etGithub.setError(("Valid Github Username mandatory"));
            etGithub.requestFocus();
        }
        Education education=new Education(etUniversity.getText().toString(), etDegree.getText().toString(), etYear.getText().toString());
        Course course=new Course(etOrganization.getText().toString(), etCourseName.getText().toString(), etCourseYear.getText().toString());
        Portfolio portfolio=new Portfolio(etName.getText().toString(), etPosition.getText().toString(), education,course, etGithub.getText().toString());


        Intent intent=new Intent();
        intent.putExtra(ABC,portfolio);
        setResult(RESULT_OK,intent);
        finish();

    }
}