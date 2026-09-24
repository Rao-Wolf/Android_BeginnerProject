package com.example.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private ArrayList<Car> cars;

    ItemClicked listener;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> cars) {
        this.cars = cars;
        listener = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMake;
        TextView tvModel, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMake = itemView.findViewById(R.id.ivMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClicked(cars.indexOf((Car) view.getTag()));
                }
            });
        }

    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(cars.get(position));

        holder.tvModel.setText(cars.get(position).getModel());
        holder.tvOwner.setText(cars.get(position).getOwnerName());

        if (cars.get(position).getMake().equals("image1")) {
            holder.ivMake.setImageResource(R.drawable.image1);
        } else if (cars.get(position).getMake().equals("image2")) {
            holder.ivMake.setImageResource(R.drawable.image2);
        } else {
            holder.ivMake.setImageResource(R.drawable.image3);
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
