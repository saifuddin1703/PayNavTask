package com.example.paynavtask.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paynavtask.R;
import com.example.paynavtask.models.usermodel;
import com.example.paynavtask.ui.DashboardFragmentDirections;
import com.example.paynavtask.ui.DashboardFragmentDirections.ActionDashboardFragmentToProfileFragment;
import com.example.paynavtask.ui.ProfileFragmentDirections;

import java.util.List;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.viewholder> {
    int count;
    List<usermodel> friends;
    public FriendListAdapter(List<usermodel> friends, int i) {
        this.friends = friends;
        count = i;
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView name;
        public viewholder(@NonNull View itemView) {
            super(itemView);
             name = itemView.findViewById(R.id.friendname);
        }
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friendlayout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        holder.name.setText(friends.get(position).getName());
        holder.itemView.setOnClickListener((View v)->{
//            v.Nav
            NavController navController = Navigation.findNavController(v);
//            Friend
//          DashboardFragmentDirections action =   new ActionDashboardFragmentToProfileFragment(friends.get(position).getName());

            DashboardFragmentDirections.ActionDashboardFragmentToProfileFragment action =  DashboardFragmentDirections.actionDashboardFragmentToProfileFragment(friends.get(position).getName());
            navController.navigate(action);

        });
    }

    @Override
    public int getItemCount() {
        return count;
    }
}
