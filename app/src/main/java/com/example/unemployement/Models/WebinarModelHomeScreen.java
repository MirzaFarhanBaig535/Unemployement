package com.example.unemployement.Models;

public class WebinarModelHomeScreen {

    int imageResource;
    String imageUrl;
    String programName;
    String programType;

    public WebinarModelHomeScreen() {
    }

    public WebinarModelHomeScreen(int imageResource, String programName, String programType) {
        this.imageResource = imageResource;
        this.programName = programName;
        this.programType = programType;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }
}
