package com.example.portfolioapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Education implements Parcelable {
    private String university;
    private String degree;
    private String year;

    public Education(String university, String degree, String year) {
        this.university = university;
        this.degree = degree;
        this.year = year;
    }
    protected Education(Parcel in){
        university=in.readString();
        degree=in.readString();
        year=in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(university);
        dest.writeString(degree);
        dest.writeString(year);

    }
}
