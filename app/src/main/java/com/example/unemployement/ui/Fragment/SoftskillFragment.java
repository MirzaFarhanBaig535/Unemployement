package com.example.unemployement.ui.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unemployement.R;
import com.example.unemployement.ui.Activity.CVbuiildingActivity;
import com.example.unemployement.ui.Activity.EntrepreneurshipActivity;
import com.example.unemployement.ui.Activity.HomeScreen;
import com.example.unemployement.ui.Activity.MainActivity;

public class SoftskillFragment extends Fragment {
    private CardView resume,entrpreneur;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SoftskillFragment() {
        // Required empty public constructor
    }

    public static SoftskillFragment newInstance(String param1, String param2) {
        SoftskillFragment fragment = new SoftskillFragment();
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
        View view =  inflater.inflate(R.layout.fragment_softskill, container, false);

        resume = view.findViewById(R.id.cv_cv);
        entrpreneur=view.findViewById(R.id.cv_entrepreneur);

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CVbuiildingActivity.class));

            }
        });

        entrpreneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), EntrepreneurshipActivity.class));

            }
        });


        return view;
    }


}