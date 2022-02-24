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

import com.example.unemployement.Adapters.WebinarAdapter;
import com.example.unemployement.Api.ApiClient;
import com.example.unemployement.Api.ApiInterface;
import com.example.unemployement.Models.WehinarModel;
import com.example.unemployement.R;
import com.example.unemployement.ui.Activity.WebinarDescActivity;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WebinarsFragment extends Fragment implements  WebinarAdapter.ItemClickListener{
    private RecyclerView rcWebinars;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public WebinarsFragment() {
    }
    public static WebinarsFragment newInstance(String param1, String param2) {
        WebinarsFragment fragment = new WebinarsFragment();
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
        View view =  inflater.inflate(R.layout.fragment_webinars, container, false);
        rcWebinars = view.findViewById(R.id.rc_webinars);
        rcWebinars.setLayoutManager(new LinearLayoutManager(this.getContext(),RecyclerView.VERTICAL,false));

        loadWebinar();

        return view;
    }

    private void loadWebinar() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Getting your webinars");
        progressDialog.show();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<WehinarModel>> getwebinars = apiInterface.getwebinars();

        getwebinars.enqueue(new Callback<ArrayList<WehinarModel>>() {
            @Override
            public void onResponse(Call<ArrayList<WehinarModel>> call, Response<ArrayList<WehinarModel>> response) {

                if (response.isSuccessful()) {
                    progressDialog.hide();
                    ArrayList<WehinarModel> value = response.body();
                    WebinarAdapter foodAdapter = new WebinarAdapter(getContext(),value, WebinarsFragment.this);
                    rcWebinars.setAdapter(foodAdapter);
                }
                else {
                    Toast.makeText(getContext(), "Server Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<WehinarModel>> call, Throwable t) {
                progressDialog.hide();

                if (t instanceof IOException) {

                }
                else {
                    Log.e("Logs",t.toString());
                }
            }
        });
    }

    @Override
    public void onItemClick(WehinarModel webinar) {
        Intent intent = new Intent(getActivity(), WebinarDescActivity.class);
        intent.putExtra("title",webinar.getTitle());
        intent.putExtra("desc",webinar.getDesc());
        intent.putExtra("id",webinar.getId());
        intent.putExtra("date",webinar.getDate());
        intent.putExtra("category",webinar.getCatagory());
        intent.putExtra("speaker",webinar.getSpeaker());
        intent.putExtra("thumbnail",webinar.getThumbnail());
        startActivity(intent);

    }
}