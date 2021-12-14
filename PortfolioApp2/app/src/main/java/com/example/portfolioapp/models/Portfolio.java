package com.example.portfolioapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Portfolio implements Parcelable {

    private String name;
    private String position;
    private Education education;
    private Course course;
    private String githubUserName;

    public Portfolio(String name, String position, Education education, Course course, String githubUserName) {
        this.name = name;
        this.position = position;
        this.education = education;
        this.course = course;
        this.githubUserName = githubUserName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGithubUserName() {
        return githubUserName;
    }

    public void setGithubUserName(String githubUserName) {
        this.githubUserName = githubUserName;
    }

    protected Portfolio(Parcel in) {
        this.name = in.readString();
        this.position = in.readString();
        this.education = in.readParcelable(Education.class.getClassLoader());
        this.course = in.readParcelable(Course.class.getClassLoader());
        this.githubUserName = in.readString();
    }

    public static final Creator<Portfolio> CREATOR = new Creator<Portfolio>() {
        @Override
        public Portfolio createFromParcel(Parcel in) {
            return new Portfolio(in);
        }

        @Override
        public Portfolio[] newArray(int size) {
            return new Portfolio[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.position);
        dest.writeParcelable(this.education, flags);
        dest.writeParcelable(this.course, flags);
        dest.writeString(this.githubUserName);
    }
}
