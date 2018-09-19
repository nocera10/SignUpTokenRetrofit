package com.signuptokenretrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.signuptokenretrofit.R;
import com.signuptokenretrofit.activity.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogImageListAdapter extends RecyclerView.Adapter<DogImageListAdapter.DogViewHolder> {

    List<String> urlImageList;
    Context context;

    public DogImageListAdapter(List<String> list, Context context) {
        this.urlImageList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DogImageListAdapter.DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dog_recyclerview_item, parent, false);
        DogViewHolder viewHolder = new DogViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DogImageListAdapter.DogViewHolder holder, int position) {

        Picasso.get().load(urlImageList.get(position)).into(holder.imageViewRv);
    }

    @Override
    public int getItemCount() {
        return urlImageList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewRv;

        public DogViewHolder(View itemView) {
            super(itemView);

            imageViewRv = itemView.findViewById(R.id.recyclerview_imageview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        String clickedRecyclerItem = urlImageList.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);

                        intent.putExtra("dog_picture", urlImageList.get(pos));

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedRecyclerItem, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
