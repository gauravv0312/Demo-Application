package com.example.demoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userHolder> {
    private Context context;
    private List<userModelClass> modelClasses;

    public userAdapter(Context context, List<userModelClass> modelClasses) {
        this.context = context;
        this.modelClasses = modelClasses;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.users,parent,false);
        return new userAdapter.userHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
//        userModelClass modelClass= modelClasses.get(position);
        holder.userId.setText(modelClasses.get(position).getId());
        holder.userEmail.setText(modelClasses.get(position).getUserEmail());
        holder.firstName.setText(modelClasses.get(position).getFirstName());
        holder.lastName.setText(modelClasses.get(position).getLastName());
        Picasso.get().load(modelClasses.get(position).getUserProfile()).into(holder.userProfile);
    }

    @Override
    public int getItemCount() {
        return modelClasses.size();
    }

    public class userHolder extends RecyclerView.ViewHolder {
        ImageView userProfile;
        TextView userId,firstName,lastName,userEmail;
        public userHolder(@NonNull View itemView) {
            super(itemView);
            userProfile=itemView.findViewById(R.id.userProfile);
            userId=itemView.findViewById(R.id.userId);
            firstName=itemView.findViewById(R.id.firstName);
            lastName=itemView.findViewById(R.id.lastName);
            userEmail=itemView.findViewById(R.id.userEmail);
        }
    }
}
