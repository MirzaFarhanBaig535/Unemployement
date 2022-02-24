package com.example.unemployement.Models;

public class InternshipModelHomeScreen {

    int internLogo;
    String internTitle;
    String internLocation;
    String internDuration;

    public InternshipModelHomeScreen() {
    }

    public InternshipModelHomeScreen(int internLogo, String internTitle, String internLocation, String internDuration) {
        this.internLogo = internLogo;
        this.internTitle = internTitle;
        this.internLocation = internLocation;
        this.internDuration = internDuration;
    }

    public int getInternLogo() {
        return internLogo;
    }

    public void setInternLogo(int internLogo) {
        this.internLogo = internLogo;
    }

    public String getInternTitle() {
        return internTitle;
    }

    public void setInternTitle(String internTitle) {
        this.internTitle = internTitle;
    }

    public String getInternLocation() {
        return internLocation;
    }

    public void setInternLocation(String internLocation) {
        this.internLocation = internLocation;
    }

    public String getInternDuration() {
        return internDuration;
    }

    public void setInternDuration(String internDuration) {
        this.internDuration = internDuration;
    }
}
