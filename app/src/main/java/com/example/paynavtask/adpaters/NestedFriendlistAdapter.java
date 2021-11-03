package com.example.paynavtask.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paynavtask.R;
import com.example.paynavtask.models.usermodel;
import com.example.paynavtask.ui.DashboardFragmentDirections;

import java.util.List;

public class NestedFriendlistAdapter extends RecyclerView.Adapter<NestedFriendlistAdapter.nestfrindlistvieholder> {
    int count;

    List<usermodel>friends;
    public NestedFriendlistAdapter(List<usermodel>friends,int i) {
        this.friends = friends;
        count = i;
    }

    class nestfrindlistvieholder extends RecyclerView.ViewHolder {
        TextView name;
        public nestfrindlistvieholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public nestfrindlistvieholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedfriendlayout, parent, false);
        return new nestfrindlistvieholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nestfrindlistvieholder holder, int position) {
        holder.name.setText(friends.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
           DashboardFragmentDirections.ActionDashboardFragmentToFriendProfileFragment action =  DashboardFragmentDirections.actionDashboardFragmentToFriendProfileFragment(friends.get(position).getName());
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }
}