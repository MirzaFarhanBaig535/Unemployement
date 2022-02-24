package com.example.unemployement.Models;

public class JobModelHomeScreen {

    int jobLogo;
    String jobTitle;
    String jobLocation;
    String jobDuration;

    public JobModelHomeScreen() {
    }

    public JobModelHomeScreen(int jobLogo, String jobTitle, String jobLocation, String jobDuration) {
        this.jobLogo = jobLogo;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.jobDuration = jobDuration;
    }

    public int getJobLogo() {
        return jobLogo;
    }

    public void setJobLogo(int jobLogo) {
        this.jobLogo = jobLogo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(String jobDuration) {
        this.jobDuration = jobDuration;
    }
}