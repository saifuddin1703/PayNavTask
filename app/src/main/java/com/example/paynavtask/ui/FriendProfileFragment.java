package com.example.paynavtask.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.paynavtask.databinding.FragmentFriendProfileBinding;

public class FriendProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFriendProfileBinding binding = FragmentFriendProfileBinding.inflate(inflater);
        String name = ProfileFragmentArgs.fromBundle(getArguments()).getName();
        binding.name.setText(name);
        return binding.getRoot();
    }
}
