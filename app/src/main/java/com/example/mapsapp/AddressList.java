package com.example.mapsapp;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mapsapp.Adapter.AddressListAdapter;
import com.example.mapsapp.Database.DBHandler;
import com.example.mapsapp.Model.PlaceModel;

import java.util.ArrayList;
import java.util.List;

public class AddressList extends AppCompatActivity {
    SwipeRefreshLayout srlLoads;
    TextView tvNoData;
    RecyclerView rvLoads;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<PlaceModel> dataArrayList;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresslist);

        srlLoads = findViewById(R.id.srlLoads);
        tvNoData = findViewById(R.id.tvNoData);
        rvLoads = findViewById(R.id.rvLoads);
        db = new DBHandler(this);
        layoutManager = new LinearLayoutManager(this);
        rvLoads.setLayoutManager(layoutManager);
        Gettinglists();
        srlLoads.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override

            public void onRefresh() {
                Gettinglists();
            }


        });
    }

    private void Gettinglists() {
        dataArrayList = new ArrayList<>();
        List<PlaceModel> addre = db.getAlladdress();
        for (PlaceModel i : addre) {
            PlaceModel data = new PlaceModel(i.getPlaceID(), i.getPlaceName(), i.getPlaceAddress());
            data.setPlaceID(i.getPlaceID());
            data.setPlaceName(i.getPlaceName());
            data.setPlaceAddress(i.getPlaceAddress());
            dataArrayList.add(data);
            Log.d("DATTTTTTTTTT", data.getPlaceID() + data.getPlaceName() + data.getPlaceAddress());
        }
        if (dataArrayList.size() > 0) {
            tvNoData.setVisibility(View.GONE);
            srlLoads.setVisibility(View.VISIBLE);
//            rvLoads.setHasFixedSize(true);

            if (dataArrayList.size() > 0) {
                tvNoData.setVisibility(View.GONE);
                srlLoads.setVisibility(View.VISIBLE);
//              rvLoads.setHasFixedSize(true);
                AddressListAdapter loadsAdapter = new AddressListAdapter(this, dataArrayList);
                rvLoads.setAdapter(loadsAdapter);

            } else {
                tvNoData.setVisibility(View.VISIBLE);
                srlLoads.setVisibility(View.GONE);
            }

        }
    }
}
