package com.example.mapsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapsapp.Model.PlaceModel;
import com.example.mapsapp.R;

import java.util.List;

public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.MyViewHolder> {

    Context context;
    List<PlaceModel> data;

    public AddressListAdapter(Context context, List<PlaceModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        final PlaceModel listApiResponse = data.get(position);

        myViewHolder.tvTitle.setText("Address");
        myViewHolder.tvId.setText(String.valueOf(listApiResponse.getPlaceID()));
        myViewHolder.tvPlaceName.setText(listApiResponse.getPlaceName());
        myViewHolder.tvPlaceAddress.setText(listApiResponse.getPlaceAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvId, tvPlaceName, tvPlaceAddress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvPlaceName = (TextView) itemView.findViewById(R.id.tvPlaceName);
            tvPlaceAddress = (TextView) itemView.findViewById(R.id.tvPlaceAddress);
        }
    }
}
