package com.example.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import org.jspecify.annotations.Nullable;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {


    Button btnCarInfo, btnOwnerInfo;
    TextView tvModel, tvTel, tvName;
    ImageView ivMake;
    View view;
    FragmentManager fragmentManager;
    Fragment listFrag, buttonFrag, carInfoFrag, ownerInfoFrag;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        listFrag = fragmentManager.findFragmentById(R.id.listFrag);
        buttonFrag = fragmentManager.findFragmentById(R.id.buttonFrag);
        carInfoFrag = fragmentManager.findFragmentById(R.id.carInfoFrag);
        ownerInfoFrag = fragmentManager.findFragmentById(R.id.ownerInfoFrag);


        fragmentManager.beginTransaction().show(listFrag).show(buttonFrag).show(carInfoFrag).hide(ownerInfoFrag).commit();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initViews();
            }
        }, 100);
    }

    private void initViews() {

        if (buttonFrag != null) {
            View buttonFragView = buttonFrag.getView();

            if (buttonFragView != null) {
                btnCarInfo = buttonFragView.findViewById(R.id.btnCarInfo);
                btnOwnerInfo = buttonFragView.findViewById(R.id.btnOwnerInfo);
            }
        }
        if (carInfoFrag != null) {
            View carinfoFragView = carInfoFrag.getView();

            if (carinfoFragView != null) {
                tvModel = carinfoFragView.findViewById(R.id.tvModel);
                ivMake = carinfoFragView.findViewById(R.id.ivMake);
            }
        }

        if (ownerInfoFrag != null) {
            View ownerInfoFragView = ownerInfoFrag.getView();

            if (ownerInfoFragView != null) {
                tvTel = ownerInfoFragView.findViewById(R.id.tvTel);
                tvName = ownerInfoFragView.findViewById(R.id.tvName);
            }
        }

        onItemClicked(0);

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager.beginTransaction().show(carInfoFrag).hide(ownerInfoFrag).commit();

                Toast.makeText(MainActivity.this, "Car Info", Toast.LENGTH_SHORT).show();
            }
        });

        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().hide(carInfoFrag).show(ownerInfoFrag).commit();

                Toast.makeText(MainActivity.this, "Owner Info", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClicked(int index) {

        tvName.setText(ApplicatonClass.cars.get(index).getOwnerName());
        tvModel.setText(ApplicatonClass.cars.get(index).getModel());
        tvTel.setText(ApplicatonClass.cars.get(index).getOwnerTel());

        if(ApplicatonClass.cars.get(index).getMake().equals("image1")) {
            ivMake.setImageResource(R.drawable.image1);
        } else if (ApplicatonClass.cars.get(index).getMake().equals("image2")) {
            ivMake.setImageResource(R.drawable.image2);
        } else {
            ivMake.setImageResource(R.drawable.image3);
        }
    }
}


