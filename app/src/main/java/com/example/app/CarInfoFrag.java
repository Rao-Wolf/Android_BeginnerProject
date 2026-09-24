package com.example.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class CarInfoFrag extends Fragment {

    View view;
    Button btnCarInfo, btnOwnerInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_car_info, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCarInfo = view.findViewById(R.id.btnCarInfo);
        btnOwnerInfo = view.findViewById(R.id.btnOwnerInfo);
    }

    public void showCarInfo () {
        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}