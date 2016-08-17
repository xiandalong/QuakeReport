package com.example.android.quakereport;


/**
 * Created by kelvin on 8/17/2016.
 */
public class Earthquake {
    private double magnitude;
    private String city;
    private long date;

    public Earthquake(double magnitude, String city, long date) {
        this.magnitude = magnitude;
        this.city = city;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
