package com.example.paynavtask.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paynavtask.R;
import com.example.paynavtask.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater);
        binding.enter.setOnClickListener(view ->
        {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_dashboardFragment);
        });
        return binding.getRoot();
    }
}