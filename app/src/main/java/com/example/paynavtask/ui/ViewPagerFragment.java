package com.example.paynavtask.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paynavtask.R;
import com.example.paynavtask.databinding.FragmentViewPagerBinding;


public class ViewPagerFragment extends Fragment {
    private String typeOfPage="";

    public ViewPagerFragment(String typeOfPage) {
        this.typeOfPage = typeOfPage;
    }

    public ViewPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       FragmentViewPagerBinding binding = FragmentViewPagerBinding.inflate(inflater);

       if (typeOfPage.equals("return")){
           binding.imageview.setImageResource(R.drawable.screenshot__236_);

           binding.returnheading.setText("RETURNED");
           binding.nextdays.setVisibility(View.GONE);
           binding.timeuntil.setVisibility(View.GONE);
       }
       if (typeOfPage.equals("receive")){
           binding.imageview.setImageResource(R.drawable.screenshot__238_);
           binding.returnheading.setText("RECEIVED");
           binding.nextdays.setVisibility(View.VISIBLE);
           binding.timeuntil.setVisibility(View.VISIBLE);
       }
        return binding.getRoot();
    }
}