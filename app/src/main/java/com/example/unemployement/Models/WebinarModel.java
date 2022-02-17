package com.example.unemployement.Models;

public class WebinarModel {

    int imageResource;
    String imageUrl;
    String programName;
    String programType;

    public WebinarModel() {
    }

    public WebinarModel(int imageResource, String programName, String programType) {
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
