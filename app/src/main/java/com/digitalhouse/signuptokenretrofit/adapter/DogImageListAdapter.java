package com.digitalhouse.signuptokenretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.digitalhouse.signuptokenretrofit.R;
import com.digitalhouse.signuptokenretrofit.activity.HuskyImagesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DogImageListAdapter extends RecyclerView.Adapter<DogImageListAdapter.DogViewHolder> {

    List<String> urlImageList;

    public DogImageListAdapter(List<String> urlImageList) {
        this.urlImageList = urlImageList;
    }

    @NonNull
    @Override
    public DogImageListAdapter.DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dog_recyclerview_item, parent, false);
        return new DogImageListAdapter.DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogImageListAdapter.DogViewHolder holder, int position) {

        Picasso.get().load(urlImageList.get(position)).into(holder.imageViewRv);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewRv;

        public DogViewHolder(View itemView) {
            super(itemView);

            imageViewRv = itemView.findViewById(R.id.recyclerview_imageview);
        }
    }
}
