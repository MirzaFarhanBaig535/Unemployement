package com.example.unemployement.Api;


import com.example.unemployement.Models.JobModel;
import com.example.unemployement.Models.WehinarModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //    GET ALL THE PRODUCTS
    @GET("/WebinarInfo/")
    Call<ArrayList<WehinarModel>> getwebinars();

    @GET("/InternshipInfo/")
    Call<ArrayList<JobModel>> getInternships();

    @GET("/JobInfo/")
    Call<ArrayList<JobModel>> getJobs();

}