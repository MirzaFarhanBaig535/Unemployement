package com.example.unemployement.ui.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.unemployement.Adapters.JobAdapter;
import com.example.unemployement.Adapters.WebinarAdapter;
import com.example.unemployement.Api.ApiClient;
import com.example.unemployement.Api.ApiInterface;
import com.example.unemployement.Models.JobModel;
import com.example.unemployement.Models.WehinarModel;
import com.example.unemployement.R;
import com.example.unemployement.ui.Activity.JobDesc;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternshipFragment extends Fragment implements  JobAdapter.ItemClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView rcInternship;
    private JobAdapter jobAdapter;

    private String mParam1;
    private String mParam2;

    public InternshipFragment() {
        // Required empty public constructor
    }

    public static InternshipFragment newInstance(String param1, String param2) {
        InternshipFragment fragment = new InternshipFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_internship, container, false);
        rcInternship = view.findViewById(R.id.rv_Internship);
        rcInternship.setLayoutManager(new LinearLayoutManager(this.getContext(),RecyclerView.VERTICAL,false));

        loadRvInternship();
        return view;
    }

    private void loadRvInternship() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Getting your internships");
        progressDialog.show();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<JobModel>> getInternships = apiInterface.getInternships();

        getInternships.enqueue(new Callback<ArrayList<JobModel>>() {
            @Override
            public void onResponse(Call<ArrayList<JobModel>> call, Response<ArrayList<JobModel>> response) {
                if (response.isSuccessful()) {
                    progressDialog.hide();
                    ArrayList<JobModel> value = response.body();
                    setRv(value);
                }
                else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<JobModel>> call, Throwable t) {
                progressDialog.hide();
                if (t instanceof IOException) {

                }
                else {
                    Log.e("Logs",t.toString());
                }
            }
        });


    }

    private void setRv(ArrayList<JobModel> value) {
        JobAdapter jobAdapter = new JobAdapter(getContext(),value,InternshipFragment.this);
        rcInternship.setAdapter(jobAdapter);
        jobAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(JobModel job) {
        Intent intent = new Intent(getActivity(), JobDesc.class);
        intent.putExtra("position",job.getPosition());
        intent.putExtra("desc",job.getDesc());
        intent.putExtra("duration",job.getDuration());
        intent.putExtra("company",job.getCompany());
        intent.putExtra("location",job.getLocation());
        intent.putExtra("type",job.getType());
        intent.putExtra("requirements",job.getRequirements());
        intent.putExtra("thumbnail",job.getThumbnail());
        startActivity(intent);
    }
}