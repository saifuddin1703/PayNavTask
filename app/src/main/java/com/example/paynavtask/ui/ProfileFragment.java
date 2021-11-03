package com.example.paynavtask.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paynavtask.R;
import com.example.paynavtask.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        FragmentProfileBinding binding = FragmentProfileBinding.inflate(inflater);
        binding.toolbar.back.setOnClickListener(view1 -> {
            Navigation.findNavController(view1).popBackStack();
//                    .navigate(R.id.action_profileFragment_to_dashboardFragment);
        });

      String name =  ProfileFragmentArgs.fromBundle(getArguments()).getName();
      binding.username.setText(name);
        binding.transactiontext.setOnClickListener(view1 -> {
            Navigation.findNavController(view1).navigate(R.id.action_profileFragment_to_transactionFragment);
        });

        binding.message.setOnClickListener(view1 -> {
            Navigation.findNavController(view1).navigate(R.id.action_profileFragment_to_messageFragment);
        });
        return binding.getRoot();
    }



}