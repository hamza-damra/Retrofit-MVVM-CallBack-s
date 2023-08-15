package com.example.retrofitmvvmcallbacks;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostModelAdapter extends RecyclerView.Adapter<PostModelAdapter.PostViewHolder> {

    List<Post> posts = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void addPosts(List<Post> posts)
    {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostModelAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostModelAdapter.PostViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.tv_userId.setText(String.valueOf(post.getUserId()));
        holder.tv_title.setText(post.getTitle());
        holder.tv_body.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_body, tv_userId;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_body = itemView.findViewById(R.id.tv_body);
            tv_userId = itemView.findViewById(R.id.tv_userId);
        }
    }
}
