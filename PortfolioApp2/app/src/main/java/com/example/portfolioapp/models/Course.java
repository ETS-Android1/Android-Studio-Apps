package com.example.portfolioapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
    private String organization;
    private String name;
    private String year;

    public Course(String organization, String name, String year) {
        this.organization = organization;
        this.name = name;
        this.year = year;
    }
    protected Course(Parcel in){
        organization=in.readString();
        name=in.readString();
        year=in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        dest.writeString(organization);
        dest.writeString(name);
        dest.writeString(year);
    }

}
